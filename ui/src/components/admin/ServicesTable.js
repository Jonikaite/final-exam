import { useEffect, useState } from "react";
import { Button, Container, Grid, Header, Table } from "semantic-ui-react";
import { Link } from "react-router-dom";

export function ServicesTable() {
  const [services, setServices] = useState([]);

  useEffect(() => {
    fetchServices();
  }, []);

  const fetchServices = () => {
    fetch("api/v1/services")
      .then((response) => response.json())
      .then(setServices);
  };

  const handleDelete = (id) => {
    fetch("api/v1/services/" + id, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    }).then(fetchServices);
  };

  return (
    <div>
      <Container>
        <Grid columns={2} divided>
          <Grid.Column>
            <Header as="h3">Servisų sąrašas</Header>
          </Grid.Column>
          <Grid.Column textAlign="right">
            <Link to="/services/create">
              <Button primary>Pridėti naują servisą</Button>
            </Link>
          </Grid.Column>
        </Grid>

        <Table celled>
          <Table.Header>
            <Table.Row>
              <Table.HeaderCell>Serviso pavadinimas</Table.HeaderCell>
              <Table.HeaderCell>Serviso adresas</Table.HeaderCell>
              <Table.HeaderCell></Table.HeaderCell>
              <Table.HeaderCell></Table.HeaderCell>
              <Table.HeaderCell></Table.HeaderCell>
            </Table.Row>
          </Table.Header>
          <Table.Body>
            {services.map((service) => (
              <Table.Row key={service.id}>
                <Table.Cell>{service.name}</Table.Cell>
                <Table.Cell>{service.address}</Table.Cell>
                <Table.Cell>
                  <Link to={"/services/view/" + service.id}>
                    <Button primary>View</Button>
                  </Link>
                </Table.Cell>
                <Table.Cell>
                  <Link to={"/services/edit/" + service.id}>
                    <Button primary>Edit</Button>
                  </Link>
                </Table.Cell>
                <Table.Cell>
                  <Button
                    primary
                    onClick={() => handleDelete(service.id)}
                  >
                    Ištrinti
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
