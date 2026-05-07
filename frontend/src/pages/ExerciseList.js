import React, { useState } from 'react';

const problems = [
  { id: 1, name: '1. Two Sum', tags: 'Mảng, Hash Table', difficulty: 'easy', diffLabel: 'Dễ', rate: '48.2%', status: 'solved' },
  { id: 2, name: '2. Add Two Numbers', tags: 'Linked List, Math', difficulty: 'medium', diffLabel: 'Trung bình', rate: '35.1%', status: 'none' },
  { id: 3, name: '4. Median of Two Sorted Arrays', tags: 'Mảng, Tìm kiếm nhị phân', difficulty: 'hard', diffLabel: 'Khó', rate: '28.5%', status: 'none' },
  { id: 4, name: '5. Longest Palindromic Substring', tags: 'Chuỗi, Quy hoạch động', difficulty: 'medium', diffLabel: 'Trung bình', rate: '32.4%', status: 'attempted' },
  { id: 5, name: '9. Palindrome Number', tags: 'Toán học', difficulty: 'easy', diffLabel: 'Dễ', rate: '51.8%', status: 'solved' },
  { id: 6, name: '11. Container With Most Water', tags: 'Mảng, Hai con trỏ', difficulty: 'medium', diffLabel: 'Trung bình', rate: '42.1%', status: 'none' },
];

const diffStyles = {
  easy: 'bg-difficulty-easy/10 text-difficulty-easy border border-difficulty-easy/20',
  medium: 'bg-difficulty-medium/10 text-difficulty-medium border border-difficulty-medium/20',
  hard: 'bg-difficulty-hard/10 text-difficulty-hard border border-difficulty-hard/20',
};

function StatusIcon({ status }) {
  if (status === 'solved') return <span className="material-symbols-outlined text-[20px] text-status-success" style={{ fontVariationSettings: "'FILL' 1" }}>check_circle</span>;
  if (status === 'attempted') return <span className="material-symbols-outlined text-[20px] text-status-warning">pending</span>;
  return <span className="material-symbols-outlined text-[20px] text-border-dark">remove</span>;
}

export default function ExerciseList() {
  const [search, setSearch] = useState('');
  const [diffFilter, setDiffFilter] = useState('');
  const [statusFilter, setStatusFilter] = useState('');

  const filtered = problems.filter((p) => {
    const matchSearch = p.name.toLowerCase().includes(search.toLowerCase()) || p.tags.toLowerCase().includes(search.toLowerCase());
    const matchDiff = !diffFilter || p.difficulty === diffFilter;
    const matchStatus = !statusFilter || p.status === statusFilter;
    return matchSearch && matchDiff && matchStatus;
  });

  return (
    <div className="flex flex-col h-full">
      {/* Header */}
      <header className="px-gutter pt-8 pb-6 border-b border-border-dark bg-background/50 backdrop-blur-lg sticky top-0 z-10">
        <div className="max-w-[1280px] mx-auto flex flex-col gap-6">
          <div>
            <h1 className="font-h1 text-h1">Kho bài tập</h1>
            <p className="font-body-md text-body-md text-on-surface-variant mt-2">Quản lý và duyệt danh sách các bài toán lập trình trong hệ thống.</p>
          </div>
          <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4">
            {/* Search */}
            <div className="relative w-full md:w-96 group">
              <span className="material-symbols-outlined absolute left-3 top-1/2 -translate-y-1/2 text-on-surface-variant group-focus-within:text-primary text-[20px] transition-colors">search</span>
              <input
                type="text"
                placeholder="Tìm bài tập, chủ đề..."
                value={search}
                onChange={(e) => setSearch(e.target.value)}
                className="w-full bg-surface-container border border-border-dark rounded-lg px-4 pl-10 py-2.5 text-on-surface font-body-md text-sm placeholder:text-on-surface-variant focus:border-primary focus:ring-1 focus:ring-primary outline-none transition-all"
              />
            </div>
            {/* Filters */}
            <div className="flex gap-3 flex-wrap">
              <div className="relative">
                <select
                  value={diffFilter}
                  onChange={(e) => setDiffFilter(e.target.value)}
                  className="appearance-none bg-surface-container border border-border-dark rounded-lg px-4 pr-10 py-2.5 text-on-surface font-body-md text-sm min-w-[160px] cursor-pointer focus:border-primary focus:ring-1 focus:ring-primary outline-none transition-all"
                >
                  <option value="">Độ khó (Tất cả)</option>
                  <option value="easy">Dễ</option>
                  <option value="medium">Trung bình</option>
                  <option value="hard">Khó</option>
                </select>
                <span className="material-symbols-outlined absolute right-3 top-1/2 -translate-y-1/2 text-on-surface-variant pointer-events-none">expand_more</span>
              </div>
              <div className="relative">
                <select
                  value={statusFilter}
                  onChange={(e) => setStatusFilter(e.target.value)}
                  className="appearance-none bg-surface-container border border-border-dark rounded-lg px-4 pr-10 py-2.5 text-on-surface font-body-md text-sm min-w-[160px] cursor-pointer focus:border-primary focus:ring-1 focus:ring-primary outline-none transition-all"
                >
                  <option value="">Trạng thái (Tất cả)</option>
                  <option value="solved">Đã giải</option>
                  <option value="attempted">Đang làm</option>
                  <option value="none">Chưa giải</option>
                </select>
                <span className="material-symbols-outlined absolute right-3 top-1/2 -translate-y-1/2 text-on-surface-variant pointer-events-none">expand_more</span>
              </div>
            </div>
          </div>
        </div>
      </header>

      {/* Table */}
      <div className="flex-1 p-gutter overflow-hidden flex flex-col max-w-[1280px] mx-auto w-full">
        <div className="bg-surface border border-border-dark rounded-xl flex-1 flex flex-col overflow-hidden shadow-lg shadow-black/20">
          <div className="flex-1 overflow-auto">
            <table className="w-full text-left whitespace-nowrap">
              <thead className="bg-surface-container-low border-b border-border-dark sticky top-0 z-[1]">
                <tr>
                  <th className="font-label-sm text-label-sm uppercase tracking-wider text-on-surface-variant font-medium px-6 py-4 w-16 text-center">Trạng thái</th>
                  <th className="font-label-sm text-label-sm uppercase tracking-wider text-on-surface-variant font-medium px-6 py-4">Tên bài</th>
                  <th className="font-label-sm text-label-sm uppercase tracking-wider text-on-surface-variant font-medium px-6 py-4 w-32">Độ khó</th>
                  <th className="font-label-sm text-label-sm uppercase tracking-wider text-on-surface-variant font-medium px-6 py-4 w-32 text-right">Tỷ lệ đúng</th>
                </tr>
              </thead>
              <tbody className="text-on-surface">
                {filtered.map((p) => (
                  <tr key={p.id} className={`border-b border-border-dark hover:bg-surface-variant/50 transition-colors cursor-pointer group ${p.status === 'attempted' ? 'bg-surface-dim/50' : ''}`}>
                    <td className="px-6 py-4 text-center"><StatusIcon status={p.status} /></td>
                    <td className="px-6 py-4">
                      <div className="font-medium text-on-surface group-hover:text-primary transition-colors">{p.name}</div>
                      <div className="font-label-sm text-label-sm text-on-surface-variant mt-1">{p.tags}</div>
                    </td>
                    <td className="px-6 py-4">
                      <span className={`font-label-sm text-[12px] font-medium inline-flex items-center px-2.5 py-1 rounded-md ${diffStyles[p.difficulty]}`}>{p.diffLabel}</span>
                    </td>
                    <td className="px-6 py-4 text-right font-code-md text-code-md text-on-surface-variant">{p.rate}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>

          {/* Pagination */}
          <div className="border-t border-border-dark bg-surface-container-low px-6 py-4 flex items-center justify-between">
            <div className="font-label-sm text-label-sm text-on-surface-variant">
              Hiển thị <span className="font-medium text-on-surface">1</span> đến <span className="font-medium text-on-surface">{filtered.length}</span> của <span className="font-medium text-on-surface">2,451</span> bài tập
            </div>
            <div className="flex gap-1">
              <button className="w-8 h-8 flex items-center justify-center rounded-md text-on-surface-variant opacity-50 cursor-not-allowed" disabled>
                <span className="material-symbols-outlined text-[18px]">chevron_left</span>
              </button>
              <button className="w-8 h-8 flex items-center justify-center rounded-md bg-primary/10 text-primary border border-primary/20 font-label-sm text-label-sm font-medium">1</button>
              {[2, 3].map((n) => (
                <button key={n} className="w-8 h-8 flex items-center justify-center rounded-md text-on-surface hover:bg-surface-variant font-label-sm text-label-sm transition-colors">{n}</button>
              ))}
              <span className="w-8 h-8 flex items-center justify-center text-on-surface-variant font-label-sm text-label-sm">...</span>
              <button className="w-8 h-8 flex items-center justify-center rounded-md text-on-surface hover:bg-surface-variant font-label-sm text-label-sm transition-colors">49</button>
              <button className="w-8 h-8 flex items-center justify-center rounded-md text-on-surface hover:bg-surface-variant transition-colors">
                <span className="material-symbols-outlined text-[18px]">chevron_right</span>
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
