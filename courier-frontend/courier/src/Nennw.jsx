import React, { Component } from "react";
import axios from "axios";
import Table1 from "./Table1";

class Nennw extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      receiverAddress: "",
      receiverName: "",
      receiverPhone: "",
      senderAddress: "",
      senderName: "",
      senderPhone: "",
    };
  }

  handleId = (event) => {
    this.setState({ id: event.target.value });
  };
  handleReceiverAddress = (event) => {
    this.setState({ receiverAddress: event.target.value });
  };
  handleReceiverName = (event) => {
    this.setState({ receiverName: event.target.value });
  };
  handleReceiverPhone = (event) => {
    this.setState({ receiverPhone: event.target.value });
  };
  handleSenderAddress = (event) => {
    this.setState({ senderAddress: event.target.value });
  };
  handleSenderName = (event) => {
    this.setState({ senderName: event.target.value });
  };
  handleSenderPhone = (event) => {
    this.setState({ senderPhone: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const data = {
      id: this.state.id,
      senderName: this.state.senderName,
      senderAddress: this.state.senderAddress,
      senderPhone: this.state.senderPhone,
      receiverName: this.state.receiverName,
      receiverPhone: this.state.receiverPhone,
      receiverAddress: this.state.receiverAddress,
    };
    console.log(data);
    axios.post("http://localhost:8080/book", data).then(() => {
      this.setState({ submitted: true });
    });
  };

  render() {
    if (this.state.submitted) {
      return <Table1 />;
    }
    return (
      <form onSubmit={this.handleSubmit} className="fuel">
        <label className="login-label">id: </label>

        <input
          className="courier"
          type="number"
          value={this.state.id}
          onChange={this.handleId}
        />

        <br></br>
        <br></br>

        <label className="login-label">Sender Name : </label>
        <input
          className="courier"
          type="text"
          value={this.state.senderName}
          onChange={this.handleSenderName}
        />

        <br></br>
        <br></br>

        <label className="login-label">Sender Address : </label>
        <input
          className="courier"
          type="text"
          value={this.state.senderAddress}
          onChange={this.handleSenderAddress}
        />

        <br></br>
        <br></br>

        <label className="login-label">Sender Phone : </label>
        <input
          className="courier"
          type="number"
          value={this.state.senderPhone}
          onChange={this.handleSenderPhone}
        />

        <br></br>
        <br></br>

        <label className="login-label">Receiver Name : </label>
        <input
          className="courier"
          type="text"
          value={this.state.receiverName}
          onChange={this.handleReceiverName}
        />

        <br></br>
        <br></br>

        <label className="login-label">Receiver Address : </label>
        <input
          className="courier"
          type="text"
          value={this.state.receiverAddress}
          onChange={this.handleReceiverAddress}
        />

        <br></br>
        <br></br>

        <label className="login-label">Receiver Phone : </label>
        <input
          className="courier"
          type="number"
          value={this.state.receiverPhone}
          onChange={this.handleReceiverPhone}
        />

        <br></br>
        <br></br>

        <button className="submitt" type="submit" id="asd">
          Submit
        </button>
        <br></br>
        <br></br>
      </form>
    );
  }
}
export default Nennw;
