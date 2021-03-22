import React from 'react';
import { Container, Table } from 'reactstrap';

const Footer = (props) => {
  return (
    <Container>
      <Table borderless>
        <thead>
          <tr>
            <th>#</th>
            <th>A Empresa</th>
            <th>Nossos Serviços</th>
            <th>Nossas Redes</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
            <td>@twitter</td>
          </tr>
        </tbody>
      </Table>
    </Container>
  );
}

export default Footer;