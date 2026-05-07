import React, { useState } from 'react';

const testCases = [
  { id: 1, nums: '[2, 7, 11, 15]', target: '9' },
  { id: 2, nums: '[3, 2, 4]', target: '6' },
  { id: 3, nums: '[3, 3]', target: '6' },
];

export default function PracticeWorkspace() {
  const [activeTab, setActiveTab] = useState('testcases');
  const [activeCase, setActiveCase] = useState(0);

  return (
    <div className="flex h-[calc(100vh-64px)] overflow-hidden bg-background">
      {/* Left: Problem Description */}
      <section className="w-2/5 min-w-[350px] flex flex-col border-r border-border-dark bg-surface overflow-y-auto max-md:w-full max-md:min-w-0 max-md:max-h-[50vh] max-md:border-r-0 max-md:border-b max-md:border-border-dark">
        <div className="p-gutter border-b border-border-dark">
          <div className="flex items-center justify-between mb-2">
            <h1 className="font-h2 text-h2">1. Tổng hai số</h1>
            <span className="font-label-sm text-[12px] font-medium inline-flex items-center px-2.5 py-1 rounded-md bg-difficulty-easy/10 text-difficulty-easy border border-difficulty-easy/20">Dễ</span>
          </div>
          <div className="flex flex-wrap gap-4 font-label-sm text-label-sm text-on-surface-variant">
            <div className="flex items-center gap-1"><span className="material-symbols-outlined text-[16px]">timer</span>Thời gian: 1.0s</div>
            <div className="flex items-center gap-1"><span className="material-symbols-outlined text-[16px]">memory</span>Bộ nhớ: 256MB</div>
          </div>
        </div>
        <div className="p-gutter flex-1 text-on-surface-variant">
          <p className="mb-4 leading-relaxed text-on-surface">
            Cho một mảng các số nguyên <code className="font-code-md text-sm text-primary bg-surface-container px-1 py-0.5 rounded-sm">nums</code> và một số nguyên{' '}
            <code className="font-code-md text-sm text-primary bg-surface-container px-1 py-0.5 rounded-sm">target</code>, hãy trả về chỉ số (index) của hai số sao cho
            tổng của chúng bằng <code className="font-code-md text-sm text-primary bg-surface-container px-1 py-0.5 rounded-sm">target</code>.
          </p>
          <p className="mb-4 leading-relaxed text-on-surface">
            Bạn có thể giả định rằng mỗi đầu vào sẽ có chính xác một nghiệm và bạn không được sử dụng
            cùng một phần tử hai lần. Bạn có thể trả về câu trả lời theo bất kỳ thứ tự nào.
          </p>
          <div className="mb-4">
            <h3 className="font-h3 text-h3 text-on-surface mb-2">Ví dụ 1:</h3>
            <div className="bg-surface-container-low border border-border-dark rounded-lg p-4 font-code-md text-code-md flex flex-col gap-1">
              <div><span className="text-outline">Input:</span> nums = [2,7,11,15], target = 9</div>
              <div><span className="text-outline">Output:</span> <span className="text-status-success">[0,1]</span></div>
              <div className="mt-2 text-outline-variant italic">Giải thích: Vì nums[0] + nums[1] == 9, nên trả về [0, 1].</div>
            </div>
          </div>
          <div className="mb-4">
            <h3 className="font-h3 text-h3 text-on-surface mb-2">Ví dụ 2:</h3>
            <div className="bg-surface-container-low border border-border-dark rounded-lg p-4 font-code-md text-code-md flex flex-col gap-1">
              <div><span className="text-outline">Input:</span> nums = [3,2,4], target = 6</div>
              <div><span className="text-outline">Output:</span> <span className="text-status-success">[1,2]</span></div>
            </div>
          </div>
          <div className="mt-8">
            <h3 className="font-h3 text-h3 text-on-surface mb-2">Ràng buộc:</h3>
            <ul className="list-disc pl-5 flex flex-col gap-2 font-code-md text-[13px] text-on-surface-variant">
              <li><code className="text-on-surface">2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
              <li><code className="text-on-surface">-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
              <li><code className="text-on-surface">-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
              <li>Chỉ có duy nhất một đáp án hợp lệ.</li>
            </ul>
          </div>
        </div>
      </section>

      {/* Right: Editor + Console */}
      <section className="flex-1 flex flex-col min-w-[500px] max-md:min-w-0">
        {/* Toolbar */}
        <div className="h-12 bg-surface flex items-center justify-between px-4 border-b border-border-dark shrink-0">
          <div className="flex items-center gap-4">
            <div className="flex items-center gap-2 bg-surface-container border border-border-dark px-3 py-1.5 rounded cursor-pointer hover:bg-surface-container-high transition-colors">
              <span className="font-label-sm text-label-sm">Python</span>
              <span className="material-symbols-outlined text-[16px] text-outline">expand_more</span>
            </div>
          </div>
          <div className="flex items-center gap-2">
            <span className="material-symbols-outlined text-[18px] text-outline cursor-pointer hover:text-on-surface transition-colors">restart_alt</span>
            <span className="material-symbols-outlined text-[18px] text-outline cursor-pointer hover:text-on-surface transition-colors">settings</span>
          </div>
        </div>

        {/* Code Editor */}
        <div className="flex-1 bg-surface-dim flex overflow-hidden">
          <div className="w-12 bg-surface-dim border-r border-border-dark flex flex-col items-end p-4 text-outline-variant font-code-md text-code-md select-none shrink-0">
            {[1, 2, 3, 4, 5, 6, 7, 8].map((n) => <div key={n}>{n}</div>)}
          </div>
          <div className="flex-1 p-4 text-on-surface overflow-auto whitespace-pre font-code-md text-code-md">
            <pre className="m-0 font-code-md text-sm leading-relaxed">
              <span className="text-primary">class</span> <span className="text-status-warning">Solution</span>:{'\n'}
              {'    '}<span className="text-primary">def</span> <span className="text-status-info">twoSum</span>(<span className="text-tertiary">self</span>, nums: <span className="text-status-warning">List</span>[<span className="text-primary">int</span>], target: <span className="text-primary">int</span>) -&gt; <span className="text-status-warning">List</span>[<span className="text-primary">int</span>]:{'\n'}
              {'        '}<span className="text-outline-variant"># Viết code của bạn ở đây</span>{'\n'}
              {'        '}<span className="text-primary">pass</span>
            </pre>
          </div>
        </div>

        {/* Console Panel */}
        <div className="h-[35%] min-h-[250px] bg-surface border-t border-border-dark flex flex-col shrink-0">
          <div className="flex items-center bg-surface-container-low border-b border-border-dark px-4 h-10 shrink-0">
            <button
              className={`h-full px-4 border-b-2 font-label-sm text-label-sm flex items-center gap-2 transition-colors ${activeTab === 'testcases' ? 'border-primary text-primary' : 'border-transparent text-outline hover:text-on-surface'}`}
              onClick={() => setActiveTab('testcases')}
            >
              <span className="material-symbols-outlined text-[16px]">terminal</span>Testcases
            </button>
            <button
              className={`h-full px-4 border-b-2 font-label-sm text-label-sm flex items-center gap-2 transition-colors ${activeTab === 'result' ? 'border-primary text-primary' : 'border-transparent text-outline hover:text-on-surface'}`}
              onClick={() => setActiveTab('result')}
            >
              <span className="material-symbols-outlined text-[16px]">play_circle</span>Kết quả chạy
            </button>
          </div>
          <div className="flex-1 p-4 overflow-y-auto">
            <div className="flex gap-2 mb-2">
              {testCases.map((tc, i) => (
                <button
                  key={tc.id}
                  className={`font-label-sm text-label-sm px-3 py-1 rounded transition-colors ${i === activeCase ? 'bg-surface-container border border-border-dark text-on-surface' : 'text-outline hover:bg-surface-container-low border border-transparent'}`}
                  onClick={() => setActiveCase(i)}
                >Case {tc.id}</button>
              ))}
            </div>
            <div className="flex flex-col gap-4 mt-4">
              <div>
                <div className="font-label-sm text-label-sm text-outline mb-1">nums =</div>
                <div className="font-code-md text-code-md bg-surface-container-low border border-border-dark rounded p-2 text-on-surface">{testCases[activeCase].nums}</div>
              </div>
              <div>
                <div className="font-label-sm text-label-sm text-outline mb-1">target =</div>
                <div className="font-code-md text-code-md bg-surface-container-low border border-border-dark rounded p-2 text-on-surface">{testCases[activeCase].target}</div>
              </div>
            </div>
          </div>
          <div className="h-14 bg-surface border-t border-border-dark flex items-center justify-end px-4 gap-3 shrink-0">
            <button className="px-6 py-2 rounded font-label-sm text-label-sm border border-outline text-on-surface flex items-center gap-2 hover:bg-surface-container transition-colors">
              <span className="material-symbols-outlined text-[18px]">play_arrow</span>Chạy thử
            </button>
            <button className="px-6 py-2 rounded font-label-sm text-label-sm bg-primary text-on-primary flex items-center gap-2 shadow-[0_0_15px_rgba(97,219,180,0.15)] hover:bg-primary-fixed-dim transition-colors">
              <span className="material-symbols-outlined text-[18px]">cloud_upload</span>Nộp bài
            </button>
          </div>
        </div>
      </section>
    </div>
  );
}
