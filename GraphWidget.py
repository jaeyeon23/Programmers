import random
import threading
import time
from PySide6.QtCore import QTimer
from PySide6.QtWidgets import QWidget, QVBoxLayout
import pyqtgraph as pg

class GraphWidget(QWidget):
    def __init__(self):
        super().__init__()

        # 데이터
        self.curr_hour = 1
        self.hours = [] # x축
        self.temperatures = [
] # y축

        self.graph_widget = pg.PlotWidget()
        self.graph_widget.setBackground('w')
        self.graph_widget.setYRange(0, 100, padding=0)
        pen = pg.mkPen(color=(255, 0, 0))

        # 요소 준비
        plot_item = self.graph_widget.getPlotItem()
        self.trace = plot_item.plot()
        view_box = plot_item.getViewBox()

        # plot item
        plot_item.setTitle("안녕하세요?")
        plot_item.setLabels(left='Temperature', bottom='Hour')
        plot_item.setMenuEnabled(False)
        plot_item.showGrid(x=True, y=True)

        # plot data
        self.trace.setPen(pen)
        self.trace.setData(self.hours, self.temperatures)

        # view box
        view_box.setMouseEnabled(x=True, y=False)

        widget_layout = QVBoxLayout()
        widget_layout.addWidget(self.graph_widget)

        self.setLayout(widget_layout)

        # auto-update
        self.timer = QTimer()
        self.timer.timeout.connect(self.update_trace)
        self.timer.start(1000)  # 1000ms 간격으로 호출

    def update_trace(self):
        self.hours.append(self.curr_hour)
        self.curr_hour += 1

        self.temperatures.append(random.randint(0, 100))

        self.trace.setData(self.hours, self.temperatures)

        # X축 범위 조정해서 최신 데이터만 보여주기
        self.graph_widget.setXRange(len(self.temperatures) - 10, len(self.temperatures))
