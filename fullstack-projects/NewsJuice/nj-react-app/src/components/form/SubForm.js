import React, { useState } from "react";
import Container from "@material-ui/core/Container";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { IconButton } from "@material-ui/core";
import RemoveIcon from "@material-ui/icons/Remove";
import AddIcon from "@material-ui/icons/Add";
import Icon from "@material-ui/core/Icon";

function SubForm() {
  const constructor = () => {
    const input = JSON.parse(localStorage.getItem("inputFields"));
    console.log("componentDidMount");
    console.log(input);
    this.state = input;
  };
  const [inputFields, setInputFields] = useState([
    { firstName: " ", lastName: " " },
  ]);

  const componentDidMount = () => {
    const input = JSON.parse(localStorage.getItem("inputFields"));
    console.log("componentDidMount");
    console.log(input);
    setInputFields(input);
  };
  const handleChangeInput = (index, event) => {
    const values = [...inputFields];
    values[index][event.target.name] = event.target.value;
    setInputFields(values);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(inputFields);
    localStorage.setItem("inputFields", JSON.stringify(inputFields));
  };

  const handleAddFields = () => {
    setInputFields([...inputFields, { firstName: " ", lastName: " " }]);
  };

  const handleRemoveFields = (index) => {
    const values = [...inputFields];
    values.splice(index, 1);
    setInputFields(values);
  };
  return (
    <Container>
      <h1> Add new subscription</h1>
      <form onSubmit={handleSubmit}>
        {inputFields.map((inputField, index) => (
          <div key={index}>
            <TextField
              name="firstName"
              label="First Name"
              value={inputField.firstName}
              onChange={(event) => handleChangeInput(index, event)}
            />
            <TextField
              name="lastName"
              label="Last Name"
              value={inputField.lastName}
              onChange={(event) => handleChangeInput(index, event)}
            />
            <IconButton onClick={() => handleRemoveFields(index)}>
              <RemoveIcon />
            </IconButton>
            <IconButton onClick={() => handleAddFields()}>
              <AddIcon />
            </IconButton>
          </div>
        ))}
        <Button
          variant="contained"
          color="primary"
          type="submit"
          onClick={handleSubmit}
        >
          Send
        </Button>
      </form>
    </Container>
  );
}
export default SubForm;
