import { configureStore } from '@reduxjs/toolkit';
import authReducer from '../features/auth/authSlice';

const store = configureStore({
  reducer: {
    auth: authReducer,
    // Add other feature reducers here
  },
});

export default store;
