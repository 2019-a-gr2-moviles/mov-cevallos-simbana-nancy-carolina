/**
 * Jugador.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    

    numeroCamiseta: {
      type: 'number',
      required: true,
    },
    nombreCamiseta: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 60,
    },
    nombreCompletoJugador: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 100,
    },
    poderEspecialDos: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 60,
    },
    fechaIngresoEquipo: {
      type: 'string',
      required: true,
    },
    goles: {
      type: 'number',
      required: true,
    },
    longitud: {
      type: 'string',
    },
    latitud: {
      type: 'string',
    },
    equipoFutbolId:{
      model:'equipo',
      required:true
    }
  },

};

