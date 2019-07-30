/**
 * Equipo.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 60,
    },

    liga: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 60,
    },

    fechaCreacion: {
      type: 'string',
      required: true,
    },

    numeroCopasInternacionales: {
      type: 'number',
      required: true,
    },

    campeonActual: {
      type: 'boolean',
      required: true,
    },

    jugadorEquipo:{
      collection:'jugador',
      via:'equipoFutbolId'
    }

  },

};

