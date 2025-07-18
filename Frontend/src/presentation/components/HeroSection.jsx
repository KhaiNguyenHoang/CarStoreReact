import React from 'react';
import { Container, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';

const HeroSection = () => {
  const textVariants = {
    initial: { y: 20, opacity: 0 },
    animate: { y: 0, opacity: 1, transition: { duration: 0.8, ease: 'easeOut' } },
  };

  const buttonVariants = {
    initial: { y: 20, opacity: 0 },
    animate: { y: 0, opacity: 1, transition: { duration: 0.8, ease: 'easeOut', delay: 0.4 } },
  };

  return (
    <div
      className="position-relative text-white text-center d-flex align-items-center justify-content-center"
      style={{
        backgroundImage: 'url(https://via.placeholder.com/1500x500?text=Amazing+Cars)',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        height: '600px',
      }}
    >
      <div
        className="position-absolute top-0 start-0 w-100 h-100"
        style={{
          background: 'linear-gradient(to bottom, rgba(0,0,0,0.6) 0%, rgba(0,0,0,0.3) 100%)',
          zIndex: 1,
        }}
      />
      <Container className="position-relative" style={{ zIndex: 2 }}>
        <motion.h1
          className="display-4 fw-bold mb-3"
          style={{ textShadow: '2px 2px 4px rgba(0,0,0,0.7)' }}
          variants={textVariants}
          initial="initial"
          animate="animate"
        >
          Find Your Dream Car
        </motion.h1>
        <motion.p
          className="lead mb-4"
          style={{ textShadow: '1px 1px 2px rgba(0,0,0,0.7)' }}
          variants={textVariants}
          initial="initial"
          animate="animate"
        >
          Explore our extensive collection of new and pre-owned vehicles.
        </motion.p>
        <motion.div variants={buttonVariants} initial="initial" animate="animate">
          <Button variant="primary" size="lg" as={Link} to="/products">
            Shop Now
          </Button>
        </motion.div>
      </Container>
    </div>
  );
};

export default HeroSection;
