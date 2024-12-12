import axios from 'axios';
import { PageResultData } from 'src/types/common';
import { SearchParamsWithUser } from 'src/types/search';
import { HistoryDTO } from 'src/types/system/history';

class HistoryApi {
  async findPage(params: SearchParamsWithUser): Promise<PageResultData<HistoryDTO>> {
    return new Promise<PageResultData<HistoryDTO>>((resolve, reject) => {
      axios.get('/api/adm/system/history', { params }).then((response) => {
        if (response.data.data) {
          resolve(response.data.data);
        } else {
          reject(response.data.error);
        }
      });
    });
  }

  getNotiHistoryById = async (id: string) => {
    const response = await axios.get(`/api/adm/system/history/${id}`);
    if (!response.data.success) {
      throw new Error('정상적으로 처리되지 않았습니다.');
    }
    return response.data.data;
  };
}

export const historyApi = new HistoryApi();
