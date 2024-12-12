import { Box, Button, Table, TableBody, TableCell, TableHead, TableRow } from '@mui/material';
import moment from 'moment';
import { useRouter } from 'next/router';
import toast from 'react-hot-toast';
import { Dispatch, SetStateAction } from 'react';
import { messageApi } from 'src/api/finder/message-api';
import { Scrollbar } from 'src/components/scrollbar';
import { HistoryDTO } from 'src/types/system/history';

import XpnrUtils from 'src/utils/xpnr-utils';
import { MessageRequest } from 'src/types/system/message';

interface HistoryListItemProp {
  filteredData?: HistoryDTO[];
  setToggle: Dispatch<SetStateAction<boolean>>;
}

function HistoryListItem({ filteredData, setToggle }: HistoryListItemProp) {
  const router = useRouter();

  const moveToDetail = (id: string) => {
    router.push({
      pathname: `/system/user/history/${id}`,
    });
  };

  const sendMessage = (item: HistoryDTO) => {
    const msgType2messageKind = (msgType: string): string => {
      if (msgType === 'MNWISE_KAKAO') {
        return 'KAKAO';
      }
      if (msgType === 'MNWISE_SMS') {
        return 'SMS';
      }
      return 'LMS';
    };

    const messageRequest: MessageRequest = {
      message: item.msgBody,
      phoneNum: JSON.parse(item.requestData.replaceAll('\n', '\\n')).phoneNum,
      smsSndNum: '0269561778',
      messageKind: msgType2messageKind(item.msgType),
      templateCode: JSON.parse(item.requestData.replaceAll('\n', '\\n')).templateCode,
      smsMessage: item.msgBody,
    };

    messageApi
      .sendMessage(messageRequest)
      .then((response) => {
        toast.success('전송에 성공했습니다.');
        setToggle((prev) => !prev);
      })
      .catch((err) => {
        toast.error(err.msg);
      });
  };

  return (
    <Scrollbar>
      <Box>
        <Table>
          <colgroup>
            <col style={{ width: '20%' }} />
            <col style={{ width: '20%' }} />
            <col style={{ width: '20%' }} />
            <col style={{ width: '20%' }} />
            <col style={{ width: '20%' }} />
          </colgroup>
          <TableHead>
            <TableRow
              sx={{
                fontWeight: 'fontWeightBold',
                height: 80,
              }}
            >
              <TableCell align="center">발송 시각</TableCell>
              <TableCell align="center">메시지 타입</TableCell>
              <TableCell align="center">알람이력 메세지 내용</TableCell>
              <TableCell align="center">수신 번호</TableCell>
              <TableCell align="center">재전송</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {filteredData &&
              filteredData.map((item) => (
                <TableRow
                  hover
                  key={item.id}
                  onClick={() => moveToDetail(item.id.toString())}
                  sx={{
                    cursor: 'pointer',
                  }}
                >
                  <TableCell align="center">{moment(item.sendDt).format('YYYY-MM-DD HH:mm:ss')}</TableCell>
                  <TableCell align="center">{item.msgType}</TableCell>
                  <TableCell align="center">{XpnrUtils.getEllipsisString(item.msgBody)}</TableCell>
                  <TableCell align="center">{JSON.parse(item.requestData.replaceAll('\n', '\\n')).phoneNum}</TableCell>
                  <TableCell align="center">
                    <Button
                      type="submit"
                      variant="contained"
                      disabled={false}
                      onClick={(event) => {
                        event.stopPropagation();
                        sendMessage(item);
                      }}
                    >
                      재전송
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
          </TableBody>
        </Table>
      </Box>
    </Scrollbar>
  );
}

export default HistoryListItem;
