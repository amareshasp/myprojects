import React from 'react';
import ReactDOM from 'react-dom';
import Analysis from './Analysis';

it('It should mount', () => {
  const div = document.createElement('div');
  ReactDOM.render(<Analysis />, div);
  ReactDOM.unmountComponentAtNode(div);
});