import React, { Component } from "react";
import axios from "axios";

class Table1 extends Component {
  constructor(props) {
    super(props);
    this.state = {
      parcels: [],
      editingParcelId: null,
      editedParcel: {},
    };
  }

  componentDidMount() {
    this.showAllParcels();
  }

  showAllParcels = () => {
    axios.get("http://localhost:8080/showAll").then((response) => {
      this.setState({ parcels: response.data });
    });
  };

  deleteParcel = (id) => {
    axios.delete(`http://localhost:8080/cancel/${id}`).then((response) => {
      console.log(response);
      this.setState({
        parcels: this.state.parcels.filter((parcel) => parcel.id !== id),
      });
    });
  };

  updateParcel = (id, updatedParcel) => {
    axios
      .put(`http://localhost:8080/update/${id}`, updatedParcel)
      .then((response) => {
        console.log(response);
        const updatedParcels = this.state.parcels.map((parcel) => {
          if (parcel.id === id) {
            return response.data;
          }
          return parcel;
        });
        this.setState({
          parcels: updatedParcels,
          editingParcelId: null,
          editedParcel: {},
        });
      });
  };

  setEditingParcel = (id) => {
    const editingParcel = this.state.parcels.find((parcel) => parcel.id === id);
    this.setState({ editingParcelId: id, editedParcel: editingParcel });
  };

  handleEditInputChange = (event) => {
    const { name, value } = event.target;
    this.setState((prevState) => ({
      editedParcel: { ...prevState.editedParcel, [name]: value },
    }));
  };

  render() {
    return (
      <div>
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
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.state.parcels.map((parcel) => (
              <tr key={parcel.id}>
                <td>{parcel.id}</td>
                {this.state.editingParcelId === parcel.id ? (
                  <React.Fragment>
                    <td>
                      <input
                        type="text"
                        name="senderName"
                        value={this.state.editedParcel.senderName || ""}
                        onChange={this.handleEditInputChange}
                      />
                    </td>
                    <td>
                      <input
                        type="text"
                        name="senderAddress"
                        value={this.state.editedParcel.senderAddress || ""}
                        onChange={this.handleEditInputChange}
                      />
                    </td>
                    <td>
                      <input
                        type="text"
                        name="senderPhone"
                        value={this.state.editedParcel.senderPhone || ""}
                        onChange={this.handleEditInputChange}
                      />
                    </td>
                    <td>
                      <input
                        type="text"
                        name="receiverName"
                        value={this.state.editedParcel.receiverName || ""}
                        onChange={this.handleEditInputChange}
                      />
                    </td>
                    <td>
                      <input
                        type="text"
                        name="receiverAddress"
                        value={this.state.editedParcel.receiverAddress || ""}
                        onChange={this.handleEditInputChange}
                      />
                    </td>
                    <td>
                      <input
                        type="text"
                        name="receiverPhone"
                        value={this.state.editedParcel.receiverPhone || ""}
                        onChange={this.handleEditInputChange}
                      />
                    </td>
                    <td>
                      <button
                        onClick={() =>
                          this.updateParcel(parcel.id, this.state.editedParcel)
                        }
                      >
                        Save
                      </button>
                      <button
                        onClick={() =>
                          this.setState({
                            editingParcelId: null,
                            editedParcel: {},
                          })
                        }
                      >
                        Cancel
                      </button>
                    </td>
                  </React.Fragment>
                ) : (
                  <React.Fragment>
                    <td>{parcel.senderName}</td>
                    <td>{parcel.senderAddress}</td>
                    <td>{parcel.senderPhone}</td>
                    <td>{parcel.receiverName}</td>
                    <td>{parcel.receiverAddress}</td>
                    <td>{parcel.receiverPhone}</td>
                    <td>
                      <button onClick={() => this.setEditingParcel(parcel.id)}>
                        Edit
                      </button>
                      <button onClick={() => this.deleteParcel(parcel.id)}>
                        Delete
                      </button>
                    </td>
                  </React.Fragment>
                )}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default Table1;
