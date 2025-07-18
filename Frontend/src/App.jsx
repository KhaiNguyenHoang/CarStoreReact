import React, { lazy, Suspense } from 'react';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ErrorBoundary from './presentation/components/ErrorBoundary';

const HomePage = lazy(() => import('./presentation/HomePage'));
const LoginForm = lazy(() => import('./presentation/components/LoginForm'));
const RegisterForm = lazy(() => import('./presentation/components/RegisterForm'));
const ProductListPage = lazy(() => import('./presentation/pages/ProductListPage'));
const ProductDetailPage = lazy(() => import('./presentation/pages/ProductDetailPage'));
const CartPage = lazy(() => import('./presentation/pages/CartPage'));
const CheckoutPage = lazy(() => import('./presentation/pages/CheckoutPage'));
const UserProfilePage = lazy(() => import('./presentation/pages/UserProfilePage'));

function App() {
  return (
    <Router>
      <ToastContainer />
      <ErrorBoundary>
        <Suspense fallback={<div>Loading...</div>}>
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/login" element={<LoginForm />} />
            <Route path="/register" element={<RegisterForm />} />
            <Route path="/products" element={<ProductListPage />} />
            <Route path="/products/:id" element={<ProductDetailPage />} />
            <Route path="/cart" element={<CartPage />} />
            <Route path="/checkout" element={<CheckoutPage />} />
            <Route path="/profile" element={<UserProfilePage />} />
          </Routes>
        </Suspense>
      </ErrorBoundary>
    </Router>
  );
}

export default App;
