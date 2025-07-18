import { configureStore } from '@reduxjs/toolkit';
import authReducer from '../application/auth/authSlice';
import cartReducer from '../application/cart/cartSlice';

const store = configureStore({
  reducer: {
    auth: authReducer,
    // Add other feature reducers here
  },
});

export default store;
