import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Footer = () => {
  return (
    <footer className="bg-dark text-white py-5 mt-auto">
      <Container>
        <Row className="justify-content-evenly">
          <Col xs={12} sm={4} md={3} className="mb-4 mb-md-0">
            <h5>CarStore</h5>
            <p className="text-muted">
              Your ultimate destination for buying and selling cars.
            </p>
          </Col>
          <Col xs={12} sm={4} md={3} className="mb-4 mb-md-0">
            <h5>Quick Links</h5>
            <ul className="list-unstyled">
              <li><Link to="/" className="text-white text-decoration-none">Home</Link></li>
              <li><Link to="/products" className="text-white text-decoration-none">Products</Link></li>
              <li><Link to="#" className="text-white text-decoration-none">About Us</Link></li>
              <li><Link to="#" className="text-white text-decoration-none">Contact</Link></li>
            </ul>
          </Col>
          <Col xs={12} sm={4} md={3} className="mb-4 mb-md-0">
            <h5>Contact Us</h5>
            <p className="text-muted">123 Car Street, Auto City</p>
            <p className="text-muted">Email: info@carstore.com</p>
            <p className="text-muted">Phone: +1 234 567 8900</p>
            <div className="mt-3">
              <a href="#" className="text-white me-2"><i className="fab fa-facebook-f"></i> Facebook</a>
              <a href="#" className="text-white me-2"><i className="fab fa-twitter"></i> Twitter</a>
              <a href="#" className="text-white"><i className="fab fa-instagram"></i> Instagram</a>
            </div>
          </Col>
        </Row>
        <Row className="mt-4">
          <Col className="text-center">
            <p className="text-muted mb-0">
              © {new Date().getFullYear()} CarStore. All rights reserved.
            </p>
          </Col>
        </Row>
      </Container>
    </footer>
  );
};

export default Footer;