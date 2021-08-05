import React from "react";
import TextField from "@material-ui/core/TextField";
import styles from "./Sub.module.css";
import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";
import InputLabel from "@material-ui/core/InputLabel";
import Button from "@material-ui/core/Button";
import Add from "@material-ui/icons/Add";

const SubList = (props) => {
  const [state, setState] = React.useState({
    age: "",
    name: "hai",
  });
  const handleChange = (event) => {};

  return props.bookDetails.map((val, idx) => {
    let name = `name-${idx}`,
      dateOfPublish = `dateOfPublish-${idx}`,
      type = `type-${idx}`,
      price = `price-${idx}`;
    return (
      <div key={val.index}>
        <TextField
          id="standard-basic"
          label="Name"
          id={name}
          className={styles.ffield}
        />

        <TextField
          id="standard-basic"
          label="Price"
          id={price}
          className={styles.ffield}
        />

        <TextField
          id="standard-basic"
          label="price"
          id={price}
          className={styles.ffield}
        />

        <Select
          native
          value={state.age}
          onChange={handleChange}
          label="Age"
          inputProps={{
            name: "age",
            id: "age-native-simple",
          }}
          className={styles.sfield}
        >
          <option value="" disabled>
            Agency
          </option>
          <option value="TOI">TOI</option>
          <option value="The Hindu">The Hindu</option>
          <option value="Hindustan">Hindustan</option>
        </Select>
        {idx === 0 ? (
          <Button
            variant="contained"
            color="primary"
            size="small"
            className={styles.button}
            startIcon={<Add />}
            onClick={() => props.add()}
          >
            ADD
          </Button>
        ) : (
          <button className="btn btn-danger" onClick={() => props.delete(val)}>
            Remove
          </button>
        )}
      </div>
    );
  });
};
export default SubList;
