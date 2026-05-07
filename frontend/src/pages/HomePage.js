import React from 'react';

export default function HomePage() {
  return (
    <div className="max-w-[1280px] mx-auto px-6">
      {/* Hero */}
      <section className="flex flex-col items-center text-center py-20 lg:py-24">
        <div className="inline-flex items-center gap-2 px-3 py-1 rounded-full bg-surface-container border border-border-dark mb-8 text-on-surface-variant">
          <span className="w-2 h-2 rounded-full bg-primary animate-pulse" />
          <span className="font-label-sm text-label-sm">Hệ thống đánh giá mã nguồn mở tự động</span>
        </div>
        <h1 className="font-h1 text-[32px] lg:text-[48px] font-bold leading-tight tracking-tighter text-on-background mb-6 max-w-3xl">
          Nền tảng luyện lập trình cho người Việt
        </h1>
        <p className="font-body-lg text-body-lg text-on-surface-variant mb-10 max-w-2xl">
          Nâng cao kỹ năng thuật toán, chuẩn bị cho các kỳ thi học sinh giỏi quốc gia và các vòng phỏng vấn kỹ thuật với hệ thống Online Judge tối ưu, tốc độ cao.
        </p>
        <div className="flex flex-wrap gap-4 justify-center">
          <button className="px-8 py-3 rounded font-h3 text-sm font-semibold bg-primary text-on-primary flex items-center gap-2 shadow-[0_0_15px_rgba(97,219,180,0.15)] hover:bg-primary-fixed-dim transition-colors active:scale-95">
            Bắt đầu luyện tập
            <span className="material-symbols-outlined text-[18px]">arrow_forward</span>
          </button>
          <button className="px-8 py-3 rounded font-h3 text-sm font-semibold bg-transparent text-on-surface border border-outline hover:bg-surface-container transition-colors active:scale-95">
            Xem bài tập
          </button>
        </div>
      </section>

      {/* Bento Features */}
      <section className="pb-16">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-gutter">
          {/* Feature 1: Wide */}
          <div className="md:col-span-2 bg-surface-container rounded-lg border border-border-dark p-8 flex flex-col relative overflow-hidden group">
            <div className="absolute inset-0 bg-gradient-to-br from-primary/5 to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-500 pointer-events-none" />
            <div className="relative z-10">
              <div className="w-12 h-12 bg-surface rounded border border-outline-variant flex items-center justify-center mb-6">
                <span className="material-symbols-outlined text-primary text-2xl">terminal</span>
              </div>
              <h3 className="font-h2 text-h2 mb-2">Online Judge Tốc Độ Cao</h3>
              <p className="font-body-md text-body-md text-on-surface-variant max-w-md">
                Hệ thống chấm điểm tự động hỗ trợ hơn 10 ngôn ngữ lập trình phổ biến bao gồm C++, Python, Java, và Rust với thời gian phản hồi mili-giây.
              </p>
            </div>
            <div className="relative z-10 mt-6 bg-surface-dim rounded border border-border-dark p-4 text-xs shadow-inner">
              <div className="flex items-center gap-2 mb-2 border-b border-border-dark pb-2">
                <span className="w-2 h-2 rounded-full bg-status-error" />
                <span className="w-2 h-2 rounded-full bg-status-warning" />
                <span className="w-2 h-2 rounded-full bg-difficulty-easy" />
                <span className="text-outline ml-2">main.cpp</span>
              </div>
              <div className="font-code-md text-code-md">
                <div className="text-primary-fixed-dim">#include &lt;iostream&gt;</div>
                <div className="text-primary-fixed-dim">using namespace std;</div>
                <br />
                <div className="text-secondary-fixed">int main() {'{'}</div>
                <div className="pl-4">int a, b;</div>
                <div className="pl-4">cin &gt;&gt; a &gt;&gt; b;</div>
                <div className="pl-4">cout &lt;&lt; a + b &lt;&lt; endl;</div>
                <div className="pl-4 text-secondary-fixed">return 0;</div>
                <div className="text-secondary-fixed">{'}'}</div>
              </div>
            </div>
          </div>

          {/* Feature 2 */}
          <div className="bg-surface-container rounded-lg border border-border-dark p-8 flex flex-col relative overflow-hidden group">
            <div className="absolute inset-0 bg-gradient-to-br from-primary/5 to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-500 pointer-events-none" />
            <div className="relative z-10">
              <div className="w-12 h-12 bg-surface rounded border border-outline-variant flex items-center justify-center mb-6">
                <span className="material-symbols-outlined text-primary text-2xl">library_books</span>
              </div>
              <h3 className="font-h2 text-h2 mb-2">Kho Bài Tập Đồ Sộ</h3>
              <p className="font-body-md text-body-md text-on-surface-variant mb-6">
                Hàng ngàn bài tập được phân loại chi tiết theo độ khó và tags thuật toán.
              </p>
            </div>
            <div className="relative z-10 mt-auto flex flex-col gap-2">
              {[
                { topic: 'Quy hoạch động', diff: 'Khó', style: 'bg-difficulty-hard/10 text-difficulty-hard border-difficulty-hard/20' },
                { topic: 'Đồ thị', diff: 'Trung bình', style: 'bg-difficulty-medium/10 text-difficulty-medium border-difficulty-medium/20' },
                { topic: 'Cấu trúc dữ liệu', diff: 'Dễ', style: 'bg-difficulty-easy/10 text-difficulty-easy border-difficulty-easy/20' },
              ].map((item, i) => (
                <div key={i} className="flex items-center justify-between p-3 bg-surface rounded border border-border-dark">
                  <span className="font-label-sm text-label-sm">{item.topic}</span>
                  <span className={`text-xs font-medium px-2 py-0.5 rounded border ${item.style}`}>{item.diff}</span>
                </div>
              ))}
            </div>
          </div>

          {/* Feature 3: Full Width */}
          <div className="md:col-span-3 bg-surface-container rounded-lg border border-border-dark p-8 relative overflow-hidden group">
            <div className="absolute inset-0 bg-gradient-to-r from-transparent via-primary/5 to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-500 pointer-events-none" />
            <div className="flex flex-col md:flex-row items-center gap-10 relative z-10">
              <div className="flex-1">
                <div className="w-12 h-12 bg-surface rounded border border-outline-variant flex items-center justify-center mb-6">
                  <span className="material-symbols-outlined text-primary text-2xl">leaderboard</span>
                </div>
                <h3 className="font-h2 text-h2 mb-2">Bảng Xếp Hạng Liên Tục</h3>
                <p className="font-body-md text-body-md text-on-surface-variant">
                  Cạnh tranh lành mạnh cùng hàng ngàn lập trình viên khác. Hệ thống xếp hạng Elo chuẩn xác cập nhật theo thời gian thực.
                </p>
              </div>
              <div className="flex-[2] w-full">
                <table className="w-full bg-surface rounded border border-border-dark overflow-hidden">
                  <thead className="bg-surface-container-high border-b border-border-dark">
                    <tr>
                      <th className="font-label-sm text-label-sm font-medium text-on-surface-variant px-4 py-3 text-left">Hạng</th>
                      <th className="font-label-sm text-label-sm font-medium text-on-surface-variant px-4 py-3 text-left">Người dùng</th>
                      <th className="font-label-sm text-label-sm font-medium text-on-surface-variant px-4 py-3 text-right">Rating</th>
                    </tr>
                  </thead>
                  <tbody>
                    {[
                      { rank: '#1', user: 'TouristVN', rating: 3452, highlight: true },
                      { rank: '#2', user: 'CodeMaster', rating: 3210 },
                      { rank: '#3', user: 'AlgoNinja', rating: 3185 },
                    ].map((r, i) => (
                      <tr key={i} className="border-b border-border-dark/50 hover:bg-surface-container-low transition-colors last:border-b-0">
                        <td className={`font-code-md text-code-md px-4 py-3 ${r.highlight ? 'text-primary' : 'text-on-surface-variant'}`}>{r.rank}</td>
                        <td className={`px-4 py-3 ${r.highlight ? 'font-medium' : ''} text-on-surface`}>{r.user}</td>
                        <td className="font-code-md text-code-md px-4 py-3 text-right text-on-surface">{r.rating}</td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}
