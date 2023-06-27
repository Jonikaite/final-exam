import React from 'react';
import { Table } from 'semantic-ui-react';

export function ServicesTable({ services }) {
  return (
    <Table>
      <Table.Header>
        {/* Table header cells */}
      </Table.Header>
      <Table.Body>
        {services.map((service) => (
          <Table.Row key={service.id}>
            {/* Table row cells */}
          </Table.Row>
        ))}
      </Table.Body>
    </Table>
  );
}