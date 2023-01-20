import React from 'react';

function LogoutButton() {
    const handleLogout = () => {
        // Code to handle logging out the user, such as removing the user's session or token
        console.log("User logged out");
    }

    return (
        <button onClick={handleLogout}>Logout</button>
    );
}

export default LogoutButton;
