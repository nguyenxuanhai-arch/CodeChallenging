import React from 'react';
import { NavLink } from 'react-router-dom';

const navLinks = [
  { path: '/practice', label: 'Luyện tập' },
  { path: '/contests', label: 'Kỳ thi' },
  { path: '/leaderboard', label: 'Bảng xếp hạng' },
  { path: '/discussions', label: 'Thảo luận' },
];

export default function Navbar() {
  return (
    <nav className="fixed top-0 w-full z-50 bg-zinc-950/80 backdrop-blur-md border-b border-zinc-800 h-16">
      <div className="flex items-center justify-between px-6 h-full w-full max-w-[1280px] mx-auto">
        <div className="flex items-center gap-8">
          <NavLink to="/" className="text-xl font-bold tracking-tighter text-zinc-100 font-h1">CodeChallenging</NavLink>
          <div className="hidden md:flex gap-6 h-16 items-center">
            {navLinks.map((link) => (
              <NavLink
                key={link.path}
                to={link.path}
                className={({ isActive }) =>
                  `font-h3 text-sm tracking-tight transition-colors duration-200 active:scale-95 flex items-center h-full ${
                    isActive
                      ? 'text-emerald-500 font-semibold border-b-2 border-emerald-500 pb-[1px]'
                      : 'text-zinc-400 font-medium hover:text-zinc-100'
                  }`
                }
              >
                {link.label}
              </NavLink>
            ))}
          </div>
        </div>
        <div className="flex items-center gap-4">
          <button className="text-zinc-400 hover:text-zinc-100 transition-colors duration-200 active:scale-95 flex items-center justify-center">
            <span className="material-symbols-outlined">notifications</span>
          </button>
          <button className="text-zinc-400 hover:text-zinc-100 transition-colors duration-200 active:scale-95 flex items-center justify-center">
            <span className="material-symbols-outlined">settings</span>
          </button>
          <div className="h-8 w-8 rounded-full overflow-hidden border border-zinc-700 bg-secondary-container text-on-secondary-container flex items-center justify-center font-label-sm text-[11px] font-semibold">
            U
          </div>
        </div>
      </div>
    </nav>
  );
}
