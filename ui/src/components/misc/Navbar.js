import React from 'react'
import { Link } from 'react-router-dom'
import { Container, Menu } from 'semantic-ui-react'
import { useAuth } from '../context/AuthContext'

export function Navbar() {
  const { getUser, userIsAuthenticated, userLogout } = useAuth()

  const logout = () => {
    userLogout()
  }

  const enterMenuStyle = () => {
    return userIsAuthenticated() ? { "display": "none" } : { "display": "block" }
  }

  const logoutMenuStyle = () => {
    return userIsAuthenticated() ? { "display": "block" } : { "display": "none" }
  }

  const adminPageStyle = () => {
    const user = getUser()
    return user && user.data.rol[0] === 'ADMIN' ? { "display": "block" } : { "display": "none" }
  }

  const userPageStyle = () => {
    const user = getUser()
    return user && user.data.rol[0] === 'USER' ? { "display": "block" } : { "display": "none" }
  }

  const getUserName = () => {
    const user = getUser()
    return user ? user.data.name : ''
  }

  return (
    <Menu inverted color='black' stackable size='massive' style={{borderRadius: 0}}>
      <Container>
        <Menu.Item as={Link} exact='true' to="/">Pagrindins</Menu.Item>

        <Menu.Item as={Link} to="/adminpage" style={adminPageStyle()}>Administratoriaus puslapis</Menu.Item>
        <Menu.Item as={Link} to="/userpage" style={userPageStyle()}>UserPage</Menu.Item>
        <Menu.Menu position='right'>
          <Menu.Item as={Link} to="/login" style={enterMenuStyle()}>Prisijungti</Menu.Item>
          <Menu.Item as={Link} to="/signup" style={enterMenuStyle()}>Užsiregistruoti</Menu.Item>
          <Menu.Item header style={logoutMenuStyle()}>{`Sveiki, ${getUserName()}`}</Menu.Item>
          <Menu.Item as={Link} to="/" style={logoutMenuStyle()} onClick={logout}>Atsijungti</Menu.Item>
        </Menu.Menu>
      </Container>
    </Menu>
  );
}
