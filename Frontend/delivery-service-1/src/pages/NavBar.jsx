import React from 'react';
import { Link } from 'react-router-dom';
import LogoutButton from './LogOut';

const NavBar = () => {
  return (
    <nav>
      <ul>
        <li>
          <button><Link to="/">Home</Link></button>
          <LogoutButton />
        </li>
      </ul>
    </nav>
  );
}

export default NavBar;
