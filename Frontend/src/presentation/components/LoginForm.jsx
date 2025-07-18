import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { loginStart, loginSuccess, loginFailure } from '../../application/auth/authSlice';
import { Form, Button, Container, Row, Col, Alert, Card } from 'react-bootstrap';
import { toast } from 'react-toastify';
import axios from 'axios';
import { GoogleLogin } from '@react-oauth/google';
import { Link } from 'react-router-dom';

const API_BASE_URL = 'http://localhost:8080'; // Thay đổi nếu backend của bạn chạy trên cổng khác

function LoginForm() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [validated, setValidated] = useState(false);
  const dispatch = useDispatch();
  const { loading, error, isAuthenticated } = useSelector((state) => state.auth);

  const handleSubmit = async (event) => {
    event.preventDefault();
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      event.stopPropagation();
    } else {
      dispatch(loginStart());

      try {
        const response = await axios.post(`${API_BASE_URL}/auth/login`, {
          email: username,
          password: password,
        });
        dispatch(loginSuccess(response.data));
        toast.success('Đăng nhập thành công!');
      } catch (err) {
        const errorMessage = err.response?.data?.message || 'Đăng nhập thất bại. Vui lòng thử lại.';
        dispatch(loginFailure(errorMessage));
        toast.error(errorMessage);
      }
    }
    setValidated(true);
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
    <Container className="d-flex justify-content-center align-items-center" style={{ minHeight: '100vh' }}>
      <Row className="w-100 justify-content-center">
        <Col xs={12} sm={8} md={6} lg={4}>
          <Card className="shadow p-4">
            <Card.Body>
              <div className="text-center mb-4">
                <i className="bi bi-lock-fill text-primary" style={{ fontSize: '3rem' }}></i>
                <h1 className="h3 mb-3 fw-normal">Đăng nhập</h1>
              </div>
              <Form noValidate validated={validated} onSubmit={handleSubmit}>
                <Form.Group className="mb-3" controlId="username">
                  <Form.Label>Tên đăng nhập</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Nhập tên đăng nhập"
                    required
                    autoFocus
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                  />
                  <Form.Control.Feedback type="invalid">
                    Vui lòng nhập tên đăng nhập.
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Group className="mb-3" controlId="password">
                  <Form.Label>Mật khẩu</Form.Label>
                  <Form.Control
                    type="password"
                    placeholder="Nhập mật khẩu"
                    required
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                  <Form.Control.Feedback type="invalid">
                    Vui lòng nhập mật khẩu.
                  </Form.Control.Feedback>
                </Form.Group>

                <Button variant="primary" type="submit" className="w-100 mb-3" disabled={loading}>
                  {loading ? 'Đang đăng nhập...' : 'Đăng nhập'}
                </Button>

                {error && (
                  <Alert variant="danger" className="text-center">
                    {error}
                  </Alert>
                )}
                {isAuthenticated && (
                  <Alert variant="success" className="text-center">
                    Bạn đã đăng nhập thành công!
                  </Alert>
                )}
              </Form>

              <div className="mt-3 text-center">
                <GoogleLogin
                  onSuccess={handleGoogleLoginSuccess}
                  onError={handleGoogleLoginError}
                  render={renderProps => (
                    <Button
                      variant="outline-danger"
                      className="w-100"
                      onClick={renderProps.onClick}
                      disabled={renderProps.disabled}
                    >
                      <i className="bi bi-google me-2"></i> Đăng nhập với Google
                    </Button>
                  )}
                />
              </div>

              <div className="text-center mt-3">
                <Link to="/register" className="text-decoration-none">
                  Chưa có tài khoản? Đăng ký
                </Link>
              </div>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
}

export default LoginForm;
