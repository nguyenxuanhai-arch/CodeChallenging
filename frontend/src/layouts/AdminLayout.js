import React from 'react';
import { Outlet } from 'react-router-dom';
import AdminSidebar from '../components/AdminSidebar';

export default function AdminLayout() {
  return (
    <div className="flex h-screen overflow-hidden">
      <AdminSidebar />
      <main className="flex-1 ml-64 h-screen overflow-y-auto bg-background p-margin-page">
        <Outlet />
      </main>
    </div>
  );
}
