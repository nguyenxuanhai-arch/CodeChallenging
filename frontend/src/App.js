import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import PublicLayout from './layouts/PublicLayout';
import AdminLayout from './layouts/AdminLayout';
import HomePage from './pages/HomePage';
import ExerciseList from './pages/ExerciseList';
import PracticeWorkspace from './pages/PracticeWorkspace';
import AdminDashboard from './pages/AdminDashboard';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* Public Routes */}
        <Route element={<PublicLayout />}>
          <Route path="/" element={<HomePage />} />
          <Route path="/practice" element={<ExerciseList />} />
          <Route path="/practice/:problemId" element={<PracticeWorkspace />} />
        </Route>

        {/* Admin Routes */}
        <Route path="/admin" element={<AdminLayout />}>
          <Route index element={<AdminDashboard />} />
          <Route path="problems" element={<ExerciseList />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
