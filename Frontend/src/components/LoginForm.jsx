import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { loginStart, loginSuccess, loginFailure } from '../features/auth/authSlice';
import { TextField, Button, Typography, Container, Box } from '@mui/material';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import GoogleIcon from '@mui/icons-material/Google';
import { toast } from 'react-toastify';
import axios from 'axios';
import { GoogleLogin } from '@react-oauth/google';

const API_BASE_URL = 'http://localhost:8080'; // Thay đổi nếu backend của bạn chạy trên cổng khác

function LoginForm({ onToggleForm }) {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const dispatch = useDispatch();
  const { loading, error, isAuthenticated } = useSelector((state) => state.auth);

  const handleSubmit = async (event) => {
    event.preventDefault();
    dispatch(loginStart());

    try {
      const response = await axios.post(`${API_BASE_URL}/auth/login`, {
        usernameOrEmail: username,
        password: password,
      });
      dispatch(loginSuccess(response.data));
      toast.success('Đăng nhập thành công!');
    } catch (err) {
      const errorMessage = err.response?.data?.message || 'Đăng nhập thất bại. Vui lòng thử lại.';
      dispatch(loginFailure(errorMessage));
      toast.error(errorMessage);
    }
  };

  const handleGoogleLoginSuccess = (credentialResponse) => {
    // Redirect to backend's Google OAuth2 endpoint
    // The backend will handle the ID token validation and user creation/login
    window.location.href = `${API_BASE_URL}/oauth2/authorization/google`;
  };

  const handleGoogleLoginError = () => {
    toast.error('Đăng nhập Google thất bại.');
  };

  return (
    <Container component="main" maxWidth="xs">
      <Box
        sx={{
          marginTop: 8,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}
      >
        <LockOutlinedIcon color="primary" sx={{ fontSize: 40 }} />
        <Typography component="h1" variant="h5">
          Đăng nhập
        </Typography>
        <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
          <TextField
            margin="normal"
            required
            fullWidth
            id="username"
            label="Tên đăng nhập"
            name="username"
            autoComplete="username"
            autoFocus
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <TextField
            margin="normal"
            required
            fullWidth
            name="password"
            label="Mật khẩu"
            type="password"
            id="password"
            autoComplete="current-password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
            disabled={loading}
          >
            {loading ? 'Đang đăng nhập...' : 'Đăng nhập'}
          </Button>
          {error && (
            <Typography color="error" variant="body2">
              {error}
            </Typography>
          )}
          {isAuthenticated && (
            <Typography color="success" variant="body2">
              Bạn đã đăng nhập thành công!
            </Typography>
          )}
        </Box>
        <Box sx={{ mt: 2 }}>
          <GoogleLogin
            onSuccess={handleGoogleLoginSuccess}
            onError={handleGoogleLoginError}
            render={renderProps => (
              <Button
                variant="outlined"
                fullWidth
                onClick={renderProps.onClick}
                disabled={renderProps.disabled}
                startIcon={<GoogleIcon />}
              >
                Đăng nhập với Google
              </Button>
            )}
          />
        </Box>
        <Button
          fullWidth
          variant="text"
          onClick={onToggleForm}
          sx={{ mt: 1 }}
        >
          Chưa có tài khoản? Đăng ký
        </Button>
      </Box>
    </Container>
  );
}

export default LoginForm;
