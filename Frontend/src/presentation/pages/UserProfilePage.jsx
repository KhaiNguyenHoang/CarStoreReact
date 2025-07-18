import React from 'react';
import { Container, Row, Col, Card, ListGroup, Button } from 'react-bootstrap';
import Header from '../components/Header';
import Footer from '../components/Footer';
import { Link } from 'react-router-dom';

const UserProfilePage = () => {
  // Mock user data
  const user = {
    fullName: 'John Doe',
    email: 'john.doe@example.com',
    address: '123 Main St, Anytown, USA',
    phone: '+1 (555) 123-4567',
  };

  // Mock order history
  const orderHistory = [
    { id: 'ORD001', date: '2024-07-10', total: '150,000', status: 'Delivered', items: ['Luxury Sedan'] },
    { id: 'ORD002', date: '2024-06-25', total: '45,000', status: 'Processing', items: ['Sport SUV'] },
  ];

  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <Container className="my-5 flex-grow-1">
        <h1 className="text-center mb-4">User Profile</h1>

        <Row className="justify-content-center">
          <Col md={8}>
            <Card className="shadow-sm mb-4">
              <Card.Header as="h5">Personal Information</Card.Header>
              <Card.Body>
                <ListGroup variant="flush">
                  <ListGroup.Item><strong>Full Name:</strong> {user.fullName}</ListGroup.Item>
                  <ListGroup.Item><strong>Email:</strong> {user.email}</ListGroup.Item>
                  <ListGroup.Item><strong>Address:</strong> {user.address}</ListGroup.Item>
                  <ListGroup.Item><strong>Phone:</strong> {user.phone}</ListGroup.Item>
                </ListGroup>
                <Button variant="primary" className="mt-3">Edit Profile</Button>
              </Card.Body>
            </Card>

            <Card className="shadow-sm">
              <Card.Header as="h5">Order History</Card.Header>
              <Card.Body>
                {orderHistory.length > 0 ? (
                  <ListGroup variant="flush">
                    {orderHistory.map(order => (
                      <ListGroup.Item key={order.id} className="d-flex justify-content-between align-items-center">
                        <div>
                          <strong>Order ID:</strong> {order.id} <br />
                          <strong>Date:</strong> {order.date} <br />
                          <strong>Items:</strong> {order.items.join(', ')}
                        </div>
                        <div>
                          <strong>Total:</strong> ${order.total} <br />
                          <strong>Status:</strong> {order.status}
                        </div>
                      </ListGroup.Item>
                    ))}
                  </ListGroup>
                ) : (
                  <p className="text-center">No orders placed yet.</p>
                )}
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
      <Footer />
    </div>
  );
};

export default UserProfilePage;
