import { Component, OnInit } from '@angular/core';
import * as echarts from 'echarts';

@Component({
  selector: 'app-compare-detail',
  templateUrl: './compare-detail.component.html',
  styleUrls: ['./compare-detail.component.css']
})
export class CompareDetailComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.initBarChart();
  }


  initBarChart(){
    var labelOption = {
      show: true,
      formatter: '{c}  {name|{a}}',
      fontSize: 16,
      rich: {
          name: {
              textBorderColor: '#fff'
          }
      }
  };
    const ec = echarts as any;
    const lineChart = ec.init(document.getElementById('lineChart'));
    const option = {
      color: ['#003366', '#006699', '#4cabce', '#e5323e'],
      tooltip: {
          trigger: 'axis',
          axisPointer: {
              type: 'shadow'
          }
      },
      legend: {
          data: ['Sina', 'Alibaba', 'Suho', 'Tencent']
      },
      toolbox: {
          show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
              mark: {show: true},
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
              restore: {show: true},
              saveAsImage: {show: true}
          }
      },
      xAxis: [
          {
              type: 'category',
              axisTick: {show: false},
              data: ['2012', '2013', '2014', '2015', '2016']
          }
      ],
      yAxis: [
          {
              type: 'value'
          }
      ],
      series: [
          {
              name: 'Sina',
              type: 'bar',
              barGap: 0,
              label: labelOption,
              data: [320, 332, 301, 334, 390]
          },
          {
              name: 'Alibaba',
              type: 'bar',
              label: labelOption,
              data: [220, 182, 191, 234, 290]
          },
          {
              name: 'Suho',
              type: 'bar',
              label: labelOption,
              data: [150, 232, 201, 154, 190]
          },
          {
              name: 'Tencent',
              type: 'bar',
              label: labelOption,
              data: [98, 77, 101, 99, 40]
          }
      ]
  }
  lineChart.setOption(option);
  }
}
