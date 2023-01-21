import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import EditProfile from './pages/EditProfile';
import ViewOrders from './pages/ViewOrders';
import SelectArea from './pages/SelectArea';
import OrderDetails from './pages/OrderDetails';
const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "/updateProfile",
    element: <EditProfile />,
  },
  {
    path: "/viewOrders",
    element: <SelectArea />,
  },
  {
    path: "/orderDetails/:custId/:vendorId" ,
    element: <OrderDetails />,
  },
]);
ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
