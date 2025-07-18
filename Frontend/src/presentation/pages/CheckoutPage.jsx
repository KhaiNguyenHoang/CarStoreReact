import React, { useState } from 'react';
import { Container, Row, Col, Form, Button, Card, ListGroup, Alert } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { clearCart } from '../../application/cart/cartSlice';
import Header from '../components/Header';
import Footer from '../components/Footer';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

const CheckoutPage = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const cart = useSelector((state) => state.cart);

  const [step, setStep] = useState(1);
  const [shippingInfo, setShippingInfo] = useState({
    fullName: '',
    address: '',
    city: '',
    zipCode: '',
    phone: '',
  });
  const [paymentMethod, setPaymentMethod] = useState('credit_card');

  const handleShippingChange = (e) => {
    setShippingInfo({ ...shippingInfo, [e.target.name]: e.target.value });
  };

  const handleNext = () => {
    // Basic validation for shipping info
    if (step === 1) {
      if (!shippingInfo.fullName || !shippingInfo.address || !shippingInfo.city || !shippingInfo.zipCode || !shippingInfo.phone) {
        toast.error('Please fill in all shipping information.');
        return;
      }
    }
    setStep(step + 1);
  };

  const handleBack = () => {
    setStep(step - 1);
  };

  const handlePlaceOrder = () => {
    // Simulate order placement
    toast.success('Order placed successfully!');
    dispatch(clearCart());
    navigate('/'); // Redirect to home after order
  };

  const renderStep = () => {
    switch (step) {
      case 1:
        return (
          <Card className="shadow-sm">
            <Card.Header as="h5">Shipping Information</Card.Header>
            <Card.Body>
              <Form>
                <Form.Group className="mb-3" controlId="fullName">
                  <Form.Label>Full Name</Form.Label>
                  <Form.Control type="text" name="fullName" value={shippingInfo.fullName} onChange={handleShippingChange} required />
                </Form.Group>
                <Form.Group className="mb-3" controlId="address">
                  <Form.Label>Address</Form.Label>
                  <Form.Control type="text" name="address" value={shippingInfo.address} onChange={handleShippingChange} required />
                </Form.Group>
                <Form.Group className="mb-3" controlId="city">
                  <Form.Label>City</Form.Label>
                  <Form.Control type="text" name="city" value={shippingInfo.city} onChange={handleShippingChange} required />
                </Form.Group>
                <Form.Group className="mb-3" controlId="zipCode">
                  <Form.Label>Zip Code</Form.Label>
                  <Form.Control type="text" name="zipCode" value={shippingInfo.zipCode} onChange={handleShippingChange} required />
                </Form.Group>
                <Form.Group className="mb-3" controlId="phone">
                  <Form.Label>Phone Number</Form.Label>
                  <Form.Control type="text" name="phone" value={shippingInfo.phone} onChange={handleShippingChange} required />
                </Form.Group>
              </Form>
            </Card.Body>
          </Card>
        );
      case 2:
        return (
          <Card className="shadow-sm">
            <Card.Header as="h5">Payment Method</Card.Header>
            <Card.Body>
              <Form>
                <Form.Group>
                  <Form.Check
                    type="radio"
                    id="creditCard"
                    label="Credit Card (Placeholder)"
                    name="paymentMethod"
                    value="credit_card"
                    checked={paymentMethod === 'credit_card'}
                    onChange={(e) => setPaymentMethod(e.target.value)}
                    className="mb-2"
                  />
                  <Form.Check
                    type="radio"
                    id="cashOnDelivery"
                    label="Cash on Delivery"
                    name="paymentMethod"
                    value="cash_on_delivery"
                    checked={paymentMethod === 'cash_on_delivery'}
                    onChange={(e) => setPaymentMethod(e.target.value)}
                  />
                </Form.Group>
              </Form>
            </Card.Body>
          </Card>
        );
      case 3:
        return (
          <Card className="shadow-sm">
            <Card.Header as="h5">Order Summary</Card.Header>
            <Card.Body>
              <h5>Shipping To:</h5>
              <ListGroup variant="flush" className="mb-3">
                <ListGroup.Item><strong>Name:</strong> {shippingInfo.fullName}</ListGroup.Item>
                <ListGroup.Item><strong>Address:</strong> {shippingInfo.address}, {shippingInfo.city}, {shippingInfo.zipCode}</ListGroup.Item>
                <ListGroup.Item><strong>Phone:</strong> {shippingInfo.phone}</ListGroup.Item>
              </ListGroup>

              <h5>Payment Method:</h5>
              <p>{paymentMethod === 'credit_card' ? 'Credit Card (Placeholder)' : 'Cash on Delivery'}</p>

              <h5 className="mt-4">Items:</h5>
              {cart.items.length === 0 ? (
                <Alert variant="warning">Your cart is empty. Please add items to proceed.</Alert>
              ) : (
                <ListGroup variant="flush">
                  {cart.items.map((item) => (
                    <ListGroup.Item key={item.id} className="d-flex justify-content-between align-items-center">
                      <div>
                        {item.name} (x{item.quantity})
                      </div>
                      <span>${item.totalPrice.toFixed(2)}</span>
                    </ListGroup.Item>
                  ))}
                  <ListGroup.Item className="d-flex justify-content-between align-items-center fw-bold">
                    Total:
                    <span>${cart.totalAmount.toFixed(2)}</span>
                  </ListGroup.Item>
                </ListGroup>
              )}
            </Card.Body>
          </Card>
        );
      default:
        return null;
    }
  };

  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <Container className="my-5 flex-grow-1">
        <h1 className="text-center mb-4">Checkout</h1>

        <Row className="justify-content-center">
          <Col md={8}>
            {renderStep()}

            <div className="d-flex justify-content-between mt-4">
              {step > 1 && (
                <Button variant="secondary" onClick={handleBack}>
                  Back
                </Button>
              )}
              {step < 3 ? (
                <Button variant="primary" onClick={handleNext} className="ms-auto">
                  Next
                </Button>
              ) : (
                <Button variant="success" onClick={handlePlaceOrder} className="ms-auto" disabled={cart.items.length === 0}>
                  Place Order
                </Button>
              )}
            </div>
          </Col>
        </Row>
      </Container>
      <Footer />
    </div>
  );
};

export default CheckoutPage;
