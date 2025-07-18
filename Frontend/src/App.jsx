import React, { useState } from 'react';
import './App.css'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import LoginForm from './components/LoginForm'
import RegisterForm from './components/RegisterForm'

function App() {
  const [showRegister, setShowRegister] = useState(false);

  const toggleForm = () => {
    setShowRegister(!showRegister);
  };

  return (
    <>
      <ToastContainer />
      {showRegister ? (
        <RegisterForm onToggleForm={toggleForm} />
      ) : (
        <LoginForm onToggleForm={toggleForm} />
      )}
    </>
  )
}

export default App
