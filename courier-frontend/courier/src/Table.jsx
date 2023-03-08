import React from "react";

function Table(props) {
  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Sender Name</th>
          <th>Sender Address</th>
          <th>Sender Phone</th>
          <th>Receiver Name</th>
          <th>Receiver Address</th>
          <th>Receiver Phone</th>
          <th>Actions</th> {/* new column for delete button */}
        </tr>
      </thead>
      <tbody>
        {props.data.map((item) => (
          <TableRow
            key={item.id}
            item={item}
            handleDelete={props.handleDelete}
          />
        ))}
      </tbody>
    </table>
  );
}

function TableRow(props) {
  const {
    id,
    senderName,
    senderAddress,
    senderPhone,
    receiverName,
    receiverAddress,
    receiverPhone,
  } = props.item;

  const handleDelete = () => {
    props.handleDelete(id);
  };

  return (
    <tr>
      <td>{id}</td>
      <td>{senderName}</td>
      <td>{senderAddress}</td>
      <td>{senderPhone}</td>
      <td>{receiverName}</td>
      <td>{receiverAddress}</td>
      <td>{receiverPhone}</td>
      <td>
        <button onClick={handleDelete}>Delete</button>
      </td>{" "}
      {/* delete button */}
    </tr>
  );
}

export default Table;
