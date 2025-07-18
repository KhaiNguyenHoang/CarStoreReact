import React from 'react';
import { Container, Row, Col, Card } from 'react-bootstrap';
import { motion } from 'framer-motion';

const cardVariants = {
  hidden: { opacity: 0, y: 50 },
  visible: { opacity: 1, y: 0, transition: { duration: 0.6, ease: 'easeOut' } },
};

const WhyChooseUs = () => {
  return (
    <div className="bg-light py-5">
      <Container>
        <h2 className="text-center mb-5">Why Choose Us?</h2>
        <Row className="g-4 justify-content-center">
          <Col xs={12} sm={6} md={4}>
            <motion.div
              variants={cardVariants}
              initial="hidden"
              whileInView="visible"
              viewport={{ once: true, amount: 0.3 }}
            >
              <Card className="h-100 text-center p-4 shadow-sm">
                <i className="bi bi-check-circle-fill text-primary mb-3" style={{ fontSize: '3rem' }}></i> {/* Placeholder for icon */}
                <h5 className="fw-bold">Quality Assurance</h5>
                <p className="text-muted">
                  Every car undergoes rigorous inspection to ensure top quality and reliability.
                </p>
              </Card>
            </motion.div>
          </Col>
          <Col xs={12} sm={6} md={4}>
            <motion.div
              variants={cardVariants}
              initial="hidden"
              whileInView="visible"
              viewport={{ once: true, amount: 0.3 }}
              transition={{ delay: 0.1 }}
            >
              <Card className="h-100 text-center p-4 shadow-sm">
                <i className="bi bi-headset text-primary mb-3" style={{ fontSize: '3rem' }}></i> {/* Placeholder for icon */}
                <h5 className="fw-bold">Excellent Support</h5>
                <p className="text-muted">
                  Our dedicated team is always ready to assist you with any queries or concerns.
                </p>
              </Card>
            </motion.div>
          </Col>
          <Col xs={12} sm={6} md={4}>
            <motion.div
              variants={cardVariants}
              initial="hidden"
              whileInView="visible"
              viewport={{ once: true, amount: 0.3 }}
              transition={{ delay: 0.2 }}
            >
              <Card className="h-100 text-center p-4 shadow-sm">
                <i className="bi bi-truck text-primary mb-3" style={{ fontSize: '3rem' }}></i> {/* Placeholder for icon */}
                <h5 className="fw-bold">Fast Delivery</h5>
                <p className="text-muted">
                  Enjoy quick and secure delivery of your dream car right to your doorstep.
                </p>
              </Card>
            </motion.div>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default WhyChooseUs;
