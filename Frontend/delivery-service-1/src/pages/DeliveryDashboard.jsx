import React from 'react';
import { Link } from "react-router-dom";
import './DeliveryDashboard.css';
import LogoutButton from './LogOut';
import ExampleComponent from './SelectArea';

function Dashboard() {
    
    const handleUpdateProfile = () => {
       
    }

    const handleViewOrders = () => {
        
    }

    return (
        <div>
            <LogoutButton />
            <h1>Welcome to the Delivery Dashboard</h1>
            <button onClick={handleUpdateProfile}><a href="/updateProfile" class="Aprofile" >Update Profile</a></button>
            <button onClick={handleViewOrders}><a href="/viewOrders" class="Aprofile" >View Orders</a></button>
            
           
        </div>
    );
}

export default Dashboard;
