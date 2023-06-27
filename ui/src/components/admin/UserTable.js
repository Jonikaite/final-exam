import React, { useState } from 'react';
import { Form, Button, Input, Table } from 'semantic-ui-react';

export function UserTable({ users, usernameSearch, handleInputChange, handleDeleteUser, handleSearchUser, handleCreateUser }) {
  const [newUser, setNewUser] = useState({
    id: '',
    username: '',
    name: '',
    email: '',
    role: '',
  });

  const resetSearch = () => {
    handleInputChange('', { name: 'usernameSearch', value: '' });
    handleSearchUser();
  };

  const handleUserInputChange = (e, { name, value }) => {
    setNewUser({ ...newUser, [name]: value });
  };

  const handleCreateUserClick = () => {
    handleCreateUser(newUser); // Pass the new user data to the backend
    setNewUser({
      id: '',
      username: '',
      name: '',
      email: '',
      role: '',
    });
  };

  let userList;
  if (users.length === 0) {
    userList = (
      <Table.Row key='no-user'>
        <Table.Cell collapsing textAlign='center' colSpan='6'>
          No user
        </Table.Cell>
      </Table.Row>
    );
  } else {
    userList = users.map((user) => {
      return (
        <Table.Row key={user.id}>
          <Table.Cell>{user.id}</Table.Cell>
          <Table.Cell>{user.username}</Table.Cell>
          <Table.Cell>{user.name}</Table.Cell>
          <Table.Cell>{user.email}</Table.Cell>
          <Table.Cell>{user.role}</Table.Cell>
          <Table.Cell collapsing>
            <Button
              circular
              color='red'
              size='small'
              icon='trash'
              disabled={user.username === 'admin'}
              onClick={() => handleDeleteUser(user.username)}
            />
          </Table.Cell>
        </Table.Row>
      );
    });
  }

  return (
    <>
      <Form>
        <Input
          type='text'
          action
          name='usernameSearch'
          placeholder='Search by Username'
          value={usernameSearch}
          onChange={handleInputChange}
        >
          <input />
          <Button circular color='green' size='small' icon='search' onClick={handleSearchUser} />
          <Button circular color='teal' size='small' icon='recycle' onClick={resetSearch} />
        </Input>
      </Form>
      <Table compact striped selectable>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell width={1}>ID</Table.HeaderCell>
            <Table.HeaderCell width={3}>Username</Table.HeaderCell>
            <Table.HeaderCell width={4}>Name</Table.HeaderCell>
            <Table.HeaderCell width={5}>Email</Table.HeaderCell>
            <Table.HeaderCell width={2}>Role</Table.HeaderCell>
            <Table.HeaderCell width={1} />
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {userList}
          <Table.Row>
            <Table.Cell>
              <Input
                type='text'
                placeholder='ID'
                name='id'
                value={newUser.id}
                onChange={handleUserInputChange}
              />
            </Table.Cell>
            <Table.Cell>
              <Input
                type='text'
                placeholder='Username'
                name='username'
                value={newUser.username}
                onChange={handleUserInputChange}
              />
            </Table.Cell>
            <Table.Cell>
              <Input
                type='text'
                placeholder='Name'
                name='name'
                value={newUser.name}
                onChange={handleUserInputChange}
              />
            </Table.Cell>
            <Table.Cell>
              <Input
                type='text'
                placeholder='Email'
                name='email'
                value={newUser.email}
                onChange={handleUserInputChange}
              />
            </Table.Cell>
            <Table.Cell>
              <Input
                type='text'
                placeholder='Role'
                name='role'
                value={newUser.role}
                onChange={handleUserInputChange}
              />
            </Table.Cell>
            <Table.Cell collapsing>
              <Button circular color='blue' size='small' icon='plus' onClick={handleCreateUserClick} />
            </Table.Cell>
          </Table.Row>
        </Table.Body>
      </Table>
    </>
  );
}
