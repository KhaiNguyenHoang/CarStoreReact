import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { loginStart, loginSuccess, loginFailure } from '../../application/auth/authSlice';
import { Form, Button, Container, Row, Col, Alert, Card } from 'react-bootstrap';
import { toast } from 'react-toastify';
import axios from 'axios';
import { Link } from 'react-router-dom';

const API_BASE_URL = 'http://localhost:8080'; // Thay đổi nếu backend của bạn chạy trên cổng khác

function RegisterForm() {
  const [fullName, setFullName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [validated, setValidated] = useState(false);
  const dispatch = useDispatch();
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (event) => {
    event.preventDefault();
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      event.stopPropagation();
    } else {
      setLoading(true);

      try {
        const response = await axios.post(`${API_BASE_URL}/auth/register`, {
          fullName,
          email,
          password,
        });
        dispatch(loginSuccess(response.data)); // Assuming backend returns LoginResponse
        toast.success('Đăng ký thành công!');
      } catch (err) {
        const errorMessage = err.response?.data?.message || 'Đăng ký thất bại. Vui lòng thử lại.';
        dispatch(loginFailure(errorMessage));
        toast.error(errorMessage);
      } finally {
        setLoading(false);
      }
    }
    setValidated(true);
  };

  return (
    <Container className="d-flex justify-content-center align-items-center" style={{ minHeight: '100vh' }}>
      <Row className="w-100 justify-content-center">
        <Col xs={12} sm={8} md={6} lg={4}>
          <Card className="shadow p-4">
            <Card.Body>
              <div className="text-center mb-4">
                <i className="bi bi-person-plus-fill text-primary" style={{ fontSize: '3rem' }}></i>
                <h1 className="h3 mb-3 fw-normal">Đăng ký</h1>
              </div>
              <Form noValidate validated={validated} onSubmit={handleSubmit}>
                <Form.Group className="mb-3" controlId="fullName">
                  <Form.Label>Họ và tên</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Nhập họ và tên"
                    required
                    autoFocus
                    value={fullName}
                    onChange={(e) => setFullName(e.target.value)}
                  />
                  <Form.Control.Feedback type="invalid">
                    Vui lòng nhập họ và tên.
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Group className="mb-3" controlId="email">
                  <Form.Label>Email</Form.Label>
                  <Form.Control
                    type="email"
                    placeholder="Nhập email"
                    required
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  />
                  <Form.Control.Feedback type="invalid">
                    Vui lòng nhập email hợp lệ.
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
                  {loading ? 'Đang đăng ký...' : 'Đăng ký'}
                </Button>
              </Form>

              <div className="text-center mt-3">
                <Link to="/login" className="text-decoration-none">
                  Đã có tài khoản? Đăng nhập
                </Link>
              </div>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
}

export default RegisterForm;
