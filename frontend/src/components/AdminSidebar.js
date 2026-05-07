import React from 'react';
import { NavLink } from 'react-router-dom';

const navItems = [
  { path: '/admin', icon: 'dashboard', label: 'Bảng điều khiển', fill: true },
  { path: '/admin/problems', icon: 'code', label: 'Kho bài tập' },
  { path: '/admin/submissions', icon: 'history', label: 'Lịch sử nộp bài' },
  { path: '/admin/achievements', icon: 'military_tech', label: 'Thành tích' },
  { path: '/admin/users', icon: 'group', label: 'Người dùng' },
  { path: '/admin/settings', icon: 'settings_suggest', label: 'Cài đặt hệ thống' },
];

export default function AdminSidebar() {
  return (
    <aside className="bg-zinc-900 font-h3 text-sm h-screen w-64 fixed left-0 top-0 border-r border-zinc-800 flex flex-col py-6 z-40">
      {/* Brand */}
      <div className="px-6 mb-8 flex items-center gap-3">
        <div className="w-10 h-10 rounded-xl bg-surface-container-high border border-border-dark flex items-center justify-center overflow-hidden shrink-0">
          <span className="material-symbols-outlined text-primary" style={{ fontVariationSettings: "'FILL' 1" }}>admin_panel_settings</span>
        </div>
        <div>
          <h2 className="text-lg font-black text-emerald-500 leading-tight">Quản trị viên</h2>
          <p className="text-zinc-500 text-xs">Hệ thống CodeChallenging</p>
        </div>
      </div>

      {/* CTA */}
      <div className="px-4 mb-6">
        <button className="w-full bg-primary text-on-primary font-label-sm text-label-sm py-2.5 px-4 rounded-lg flex items-center justify-center gap-2 hover:opacity-90 active:scale-95 transition-all">
          <span className="material-symbols-outlined text-[18px]">add</span>
          Thêm bài tập mới
        </button>
      </div>

      {/* Nav */}
      <nav className="flex-1 flex flex-col gap-1 overflow-y-auto px-2">
        {navItems.map((item) => (
          <NavLink
            key={item.path}
            to={item.path}
            end={item.path === '/admin'}
            className={({ isActive }) =>
              isActive
                ? 'flex items-center gap-3 bg-emerald-500/10 text-emerald-500 border-r-4 border-emerald-500 rounded-r-none px-4 py-3 rounded-lg transition-all active:opacity-80'
                : 'flex items-center gap-3 text-zinc-400 hover:bg-zinc-800/50 px-4 py-3 rounded-lg transition-all active:opacity-80 group'
            }
          >
            <span
              className="material-symbols-outlined text-[20px] group-hover:text-emerald-400 transition-colors"
              style={item.fill ? { fontVariationSettings: "'FILL' 1" } : {}}
            >
              {item.icon}
            </span>
            <span>{item.label}</span>
          </NavLink>
        ))}
      </nav>

      {/* Footer */}
      <div className="mt-auto px-2 flex flex-col gap-1 pt-6 border-t border-zinc-800 mx-4">
        <a href="#help" className="flex items-center gap-3 text-zinc-400 hover:bg-zinc-800/50 px-4 py-2.5 rounded-lg transition-all active:opacity-80 group">
          <span className="material-symbols-outlined text-[20px] group-hover:text-zinc-200 transition-colors">help_outline</span>
          Trợ giúp
        </a>
        <a href="#logout" className="flex items-center gap-3 text-zinc-400 hover:bg-zinc-800/50 px-4 py-2.5 rounded-lg transition-all active:opacity-80 group">
          <span className="material-symbols-outlined text-[20px] group-hover:text-red-400 transition-colors">logout</span>
          <span className="group-hover:text-red-400 transition-colors">Đăng xuất</span>
        </a>
      </div>
    </aside>
  );
}
