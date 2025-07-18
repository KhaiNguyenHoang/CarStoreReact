import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import HeroSection from './components/HeroSection';
import FeaturedProducts from './components/FeaturedProducts';
import CategoriesSection from './components/CategoriesSection';
import WhyChooseUs from './components/WhyChooseUs';
import { Box, Container } from '@mui/material';

const HomePage = () => {
  return (
    <Box sx={{ display: 'flex', flexDirection: 'column', minHeight: '100vh', bgcolor: 'background.default' }}>
      <Header />
      <HeroSection />
      <Container component="main" sx={{ py: 8 }} maxWidth="lg">
        <FeaturedProducts />
        <CategoriesSection />
        <WhyChooseUs />
      </Container>
      <Footer />
    </Box>
  );
};

export default HomePage;
