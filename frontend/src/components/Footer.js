import React from 'react';

export default function Footer() {
  return (
    <footer className="w-full py-8 mt-auto bg-zinc-950 border-t border-zinc-900">
      <div className="max-w-7xl mx-auto flex flex-col md:flex-row justify-between items-center px-6 gap-4">
        <p className="font-h3 text-xs text-zinc-300 font-bold">
          © 2024 CodeChallenging. Tối ưu cho lập trình viên Việt Nam.
        </p>
        <div className="flex gap-6">
          <a href="#terms" className="font-h3 text-xs text-zinc-500 hover:text-emerald-400 underline underline-offset-4 transition-opacity">Điều khoản</a>
          <a href="#privacy" className="font-h3 text-xs text-zinc-500 hover:text-emerald-400 underline underline-offset-4 transition-opacity">Bảo mật</a>
          <a href="#contact" className="font-h3 text-xs text-zinc-500 hover:text-emerald-400 underline underline-offset-4 transition-opacity">Liên hệ</a>
          <a href="#github" className="font-h3 text-xs text-zinc-500 hover:text-emerald-400 underline underline-offset-4 transition-opacity">Github</a>
        </div>
      </div>
    </footer>
  );
}
