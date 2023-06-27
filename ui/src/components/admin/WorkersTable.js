import React, { useState, useEffect } from 'react';
import { Table, Container, Button, Grid } from 'semantic-ui-react';
import { Link } from 'react-router-dom';

export function WorkersTable() {
  const [workers, setWorkers] = useState([]);

  useEffect(() => {
    fetchWorkers();
  }, []);

  const fetchWorkers = () => {
    fetch('api/v1/workers')
      .then((response) => response.json())
      .then(setWorkers);
  };

  const handleDelete = (id) => {
    fetch(`api/v1/workers/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(fetchWorkers);
  };

  return (
    <div>
      <Container fluid>
        <Grid columns={2}>
          <Grid.Column>
            <h3>Workers</h3>
          </Grid.Column>
          <Grid.Column textAlign="right">
            <Link to="/workers/create">
              <Button primary>Add new worker</Button>
            </Link>
          </Grid.Column>
        </Grid>

        <Table celled>
          <Table.Header>
            <Table.Row>
              <Table.HeaderCell>Name</Table.HeaderCell>
              <Table.HeaderCell>Last name</Table.HeaderCell>
              <Table.HeaderCell>City</Table.HeaderCell>
              <Table.HeaderCell>Specialization</Table.HeaderCell>
              <Table.HeaderCell>Manager</Table.HeaderCell>
              <Table.HeaderCell>Service</Table.HeaderCell>
              <Table.HeaderCell></Table.HeaderCell>
              <Table.HeaderCell></Table.HeaderCell>
            </Table.Row>
          </Table.Header>
          <Table.Body>
            {workers.map((worker) => (
              <Table.Row key={worker.id}>
                <Table.Cell>{worker.name}</Table.Cell>
                <Table.Cell>{worker.lastName}</Table.Cell>
                <Table.Cell>{worker.city}</Table.Cell>
                <Table.Cell>{worker.specialization}</Table.Cell>
                <Table.Cell>{worker.manager}</Table.Cell>
                <Table.Cell>
                  <Link to={`/workers/view/${worker.id}`}>
                    <Button primary>View</Button>
                  </Link>
                </Table.Cell>
                <Table.Cell>
                  <Link to={`/workers/edit/${worker.id}`}>
                    <Button primary>Edit</Button>
                  </Link>
                </Table.Cell>
                <Table.Cell>
                  <Button primary onClick={() => handleDelete(worker.id)}>
                    Delete
                  </Button>
                </Table.Cell>
              </Table.Row>
            ))}
          </Table.Body>
        </Table>
      </Container>
    </div>
  );
}
