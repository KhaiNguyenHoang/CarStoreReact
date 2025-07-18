import { createSlice } from '@reduxjs/toolkit';
import { toast } from 'react-toastify';

const cartSlice = createSlice({
  name: 'cart',
  initialState: {
    items: [],
    totalQuantity: 0,
    totalAmount: 0,
  },
  reducers: {
    addToCart(state, action) {
      const newItem = action.payload;
      const existingItem = state.items.find(item => item.id === newItem.id);

      if (!existingItem) {
        state.items.push({
          id: newItem.id,
          name: newItem.name,
          price: newItem.price,
          image: newItem.image,
          quantity: 1,
          totalPrice: newItem.price,
        });
      } else {
        existingItem.quantity++;
        existingItem.totalPrice = existingItem.totalPrice + newItem.price;
      }
      state.totalQuantity++;
      state.totalAmount = state.totalAmount + newItem.price;
      toast.success(`${newItem.name} added to cart!`);
    },
    removeFromCart(state, action) {
      const id = action.payload;
      const existingItem = state.items.find(item => item.id === id);

      if (existingItem) {
        state.totalQuantity = state.totalQuantity - existingItem.quantity;
        state.totalAmount = state.totalAmount - existingItem.totalPrice;
        state.items = state.items.filter(item => item.id !== id);
        toast.info(`${existingItem.name} removed from cart.`);
      }
    },
    updateQuantity(state, action) {
      const { id, quantity } = action.payload;
      const existingItem = state.items.find(item => item.id === id);

      if (existingItem) {
        const oldQuantity = existingItem.quantity;
        const priceChange = (quantity - oldQuantity) * existingItem.price;

        existingItem.quantity = quantity;
        existingItem.totalPrice = existingItem.price * quantity;

        state.totalQuantity = state.totalQuantity + (quantity - oldQuantity);
        state.totalAmount = state.totalAmount + priceChange;
        toast.info(`Quantity of ${existingItem.name} updated.`);
      }
    },
    clearCart(state) {
      state.items = [];
      state.totalQuantity = 0;
      state.totalAmount = 0;
      toast.info('Cart cleared.');
    },
  },
});

export const { addToCart, removeFromCart, updateQuantity, clearCart } = cartSlice.actions;

export default cartSlice.reducer;
