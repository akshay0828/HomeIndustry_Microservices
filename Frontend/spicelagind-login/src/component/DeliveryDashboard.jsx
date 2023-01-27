import React from 'react';

import './DeliveryDashboard.css';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import LogoutButton from './LogOut';

function Dashboard() {

    const {id}=useParams();
    
    const handleUpdateProfile = () => {
       
    }

    const handleViewOrders = () => {
        
    }

    return (
        <div className="delivery-dashboard">
        <div className='content-delivery'>
            
            <div className="welcome-message">
               Welcome to your delivery dashboard
            </div>
            <div className="button-container">
                <Link to={`/updateProfile/${id}`}>
            <button className="update-profile-button">Update Profile</button>
            </Link>
            <Link to={`/Orders/${id}`}>
            <button onClick={handleViewOrders} className="view-orders-button">View Orders</button> </Link>
            </div>
           
            

        </div>
        </div>
    );
}

export default Dashboard;

