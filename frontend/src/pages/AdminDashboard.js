import React from 'react';

const statsCards = [
  { icon: 'group', label: 'Tổng người dùng', value: '12,450', trend: '+12% so với tháng trước', trendIcon: 'trending_up', trendColor: 'text-status-success' },
  { icon: 'code', label: 'Tổng bài tập', value: '842', trend: '+15 bài mới tuần này', trendIcon: 'add', trendColor: 'text-status-success' },
  { icon: 'history', label: 'Tổng bài nộp', value: '1.2M', trend: '~450 bài nộp/ngày', trendIcon: 'speed', trendColor: 'text-on-surface-variant' },
];

const chartBars = [30, 50, 40, 70, 60, 90, 100, 80, 45, 65];

const serverMetrics = [
  { label: 'CPU Usage', value: 78, color: 'bg-status-warning' },
  { label: 'Memory (RAM)', value: 45, color: 'bg-status-success' },
  { label: 'Storage (SSD)', value: 92, color: 'bg-status-error' },
];

const pendingSubmissions = [
  { id: '#SUB-8492', user: 'tuananh_dev', initial: 'T', problem: 'Two Sum', lang: 'C++', time: 'Vài giây trước', status: 'Đang chấm...', statusIcon: 'sync', spinning: true },
  { id: '#SUB-8491', user: 'hoang_minh', initial: 'H', problem: 'Longest Substring', lang: 'Python', time: '1 phút trước', status: 'Chờ xếp hàng', statusIcon: 'hourglass_empty' },
  { id: '#SUB-8490', user: 'linh_vu', initial: 'L', problem: 'Binary Tree Level Order', lang: 'Java', time: '3 phút trước', status: 'Chờ xếp hàng', statusIcon: 'hourglass_empty' },
  { id: '#SUB-8489', user: 'duc_tran', initial: 'D', problem: 'Merge K Sorted Lists', lang: 'Go', time: '5 phút trước', status: 'Chờ xếp hàng', statusIcon: 'hourglass_empty' },
];

export default function AdminDashboard() {
  return (
    <div className="max-w-[1280px]">
      {/* Header */}
      <header className="flex justify-between items-end mb-8">
        <div>
          <h1 className="font-h1 text-h1">Tổng quan hệ thống</h1>
          <p className="font-body-md text-body-md text-on-surface-variant mt-1">Thống kê hoạt động và dữ liệu trong 30 ngày qua.</p>
        </div>
        <div className="font-label-sm text-label-sm text-on-surface-variant bg-surface-container px-3 py-1.5 rounded-full border border-border-dark flex items-center gap-2">
          <span className="w-2 h-2 rounded-full bg-status-success inline-block" />
          Hệ thống hoạt động ổn định
        </div>
      </header>

      {/* Stats Grid */}
      <div className="grid grid-cols-1 md:grid-cols-3 gap-gutter mb-8">
        {statsCards.map((card, i) => (
          <div key={i} className="bg-surface-container border border-border-dark rounded-xl p-gutter flex flex-col relative overflow-hidden hover:border-outline-variant transition-colors group">
            <div className="absolute -right-6 -top-6 text-surface-container-high opacity-100 rotate-12 group-hover:scale-110 transition-transform">
              <span className="material-symbols-outlined" style={{ fontVariationSettings: "'FILL' 1", fontSize: 120 }}>{card.icon}</span>
            </div>
            <div className="font-label-sm text-label-sm text-on-surface-variant flex items-center gap-2 mb-4 relative z-10">
              <span className="material-symbols-outlined text-[18px]">{card.icon}</span>
              {card.label}
            </div>
            <div className="font-code-md text-[30px] font-bold text-on-background relative z-10 mb-2">{card.value}</div>
            <div className={`font-label-sm text-[12px] font-medium flex items-center gap-1 relative z-10 ${card.trendColor}`}>
              <span className="material-symbols-outlined text-[14px]">{card.trendIcon}</span>
              {card.trend}
            </div>
          </div>
        ))}
      </div>

      {/* Charts Row */}
      <div className="grid grid-cols-1 lg:grid-cols-3 gap-gutter mb-8">
        {/* Activity Chart */}
        <div className="lg:col-span-2 bg-surface-container border border-border-dark rounded-xl p-gutter flex flex-col h-[400px]">
          <div className="flex justify-between items-center mb-4">
            <h3 className="font-h3 text-h3">Biểu đồ hoạt động hệ thống</h3>
            <div className="flex gap-2">
              <button className="bg-surface-container-high text-on-surface-variant font-label-sm text-label-sm px-3 py-1 rounded-lg border border-border-dark hover:text-on-background transition-colors">7 Ngày</button>
              <button className="bg-primary-container text-on-primary-container font-label-sm text-label-sm px-3 py-1 rounded-lg border border-primary/20">30 Ngày</button>
            </div>
          </div>
          <div className="flex-1 border-b border-l border-border-dark flex items-end justify-between px-2 pt-8 gap-2">
            {chartBars.map((h, i) => (
              <div key={i} className={`flex-1 rounded-t-sm transition-colors duration-200 hover:bg-primary/40 ${i === 6 ? 'bg-primary/40 hover:bg-primary/60' : 'bg-primary/20'}`} style={{ height: `${h}%` }} />
            ))}
          </div>
          <div className="flex justify-between text-on-surface-variant font-code-md text-label-sm mt-2 px-2">
            <span>01/10</span>
            <span>15/10</span>
            <span>30/10</span>
          </div>
        </div>

        {/* Server Load */}
        <div className="bg-surface-container border border-border-dark rounded-xl p-gutter flex flex-col">
          <h3 className="font-h3 text-h3 mb-4">Tải Server (Real-time)</h3>
          <div className="flex-1 flex flex-col justify-center gap-8">
            {serverMetrics.map((m, i) => (
              <div key={i}>
                <div className="font-label-sm text-label-sm flex justify-between text-on-surface-variant mb-2">
                  <span>{m.label}</span>
                  <span className={m.value >= 80 ? 'text-status-error' : m.value >= 60 ? 'text-status-warning' : 'text-status-success'}>{m.value}%</span>
                </div>
                <div className="w-full h-2 bg-surface-container-highest rounded-full overflow-hidden">
                  <div className={`h-full rounded-full transition-all duration-500 ${m.color}`} style={{ width: `${m.value}%` }} />
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>

      {/* Pending Submissions */}
      <div className="bg-surface-container border border-border-dark rounded-xl overflow-hidden flex flex-col">
        <div className="p-gutter border-b border-border-dark flex justify-between items-center bg-surface-container-low">
          <div>
            <h3 className="font-h3 text-h3">Bài nộp đang chờ chấm</h3>
            <p className="font-body-md text-body-md text-on-surface-variant mt-1">Hàng đợi chấm tự động đang xử lý 12 tác vụ.</p>
          </div>
          <button className="bg-surface-container-high text-on-surface p-2 rounded-lg border border-border-dark hover:text-primary transition-colors flex items-center justify-center">
            <span className="material-symbols-outlined text-[20px]">refresh</span>
          </button>
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-left">
            <thead className="bg-surface-container-highest">
              <tr>
                {['ID', 'Người dùng', 'Bài tập', 'Ngôn ngữ', 'Thời gian', 'Trạng thái', ''].map((h, i) => (
                  <th key={i} className={`font-label-sm text-label-sm uppercase tracking-wider text-on-surface-variant font-medium px-4 py-3 border-b border-border-dark whitespace-nowrap ${i === 6 ? 'text-right' : ''}`}>{h || 'Hành động'}</th>
                ))}
              </tr>
            </thead>
            <tbody className="text-on-background">
              {pendingSubmissions.map((sub) => (
                <tr key={sub.id} className="border-b border-border-dark hover:bg-surface-container-high transition-colors last:border-b-0 group">
                  <td className="px-4 py-3 font-code-md text-code-md text-on-surface-variant whitespace-nowrap">{sub.id}</td>
                  <td className="px-4 py-3 whitespace-nowrap">
                    <div className="flex items-center gap-2">
                      <div className="w-6 h-6 rounded-full bg-secondary-container text-on-secondary-container flex items-center justify-center font-label-sm text-[10px] font-semibold">{sub.initial}</div>
                      {sub.user}
                    </div>
                  </td>
                  <td className="px-4 py-3 font-code-md text-code-md whitespace-nowrap">{sub.problem}</td>
                  <td className="px-4 py-3 whitespace-nowrap"><span className="bg-surface-variant text-on-surface font-code-md text-[12px] px-2 py-1 rounded">{sub.lang}</span></td>
                  <td className="px-4 py-3 text-on-surface-variant text-sm whitespace-nowrap">{sub.time}</td>
                  <td className="px-4 py-3 whitespace-nowrap">
                    <span className="bg-surface-variant/50 text-status-warning border border-status-warning/20 inline-flex items-center gap-1.5 px-2.5 py-1 rounded-full text-xs font-medium">
                      <span className={`material-symbols-outlined text-[14px] ${sub.spinning ? 'animate-spin' : ''}`}>{sub.statusIcon}</span>
                      {sub.status}
                    </span>
                  </td>
                  <td className="px-4 py-3 text-right whitespace-nowrap">
                    <button className="text-on-surface-variant opacity-0 group-hover:opacity-100 hover:text-primary transition-all">
                      <span className="material-symbols-outlined text-[18px]">visibility</span>
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        <div className="px-4 py-4 border-t border-border-dark bg-surface-container-low flex justify-center">
          <button className="font-label-sm text-label-sm text-primary flex items-center gap-1 hover:text-primary-fixed transition-colors">
            Xem toàn bộ hàng đợi
            <span className="material-symbols-outlined text-[16px]">arrow_forward</span>
          </button>
        </div>
      </div>
    </div>
  );
}
