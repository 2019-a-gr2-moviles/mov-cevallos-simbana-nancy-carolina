/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    
    nombre: {
      type:'string',
      required: true,
      minLenght: 3,
      maxLenght: 60
    },
    cedula: {
      type:'string',
      required: true,
      unique: true,
      minLenght: 10,
      maxLenght: 25
    },
    username: {
      type:'string',
      required: true,
      unique: true
    },
    fechaNacimiento: {
      type:'string'
    },
    sueldo: {
      type: 'number',
      defaultsTo: 100.00,
      min: 5000,
      max: 10000
    },
    estaCasado: {
      type: 'boolean',
      defaultsTo: false
    },
    latitudCasa: {
      type: 'string'
    },
    longitudCasa: {
      type: 'string'
    },
    tipoUsuario: {
      type: 'string',
      enum: ['normal', 'pendiente', 'premium']
    },
    correo: {
      type: 'string',
      isEmail: true
    },
    //configuracion del PAPA
    serviciosDeUsuario: {         //Nombre atributo relacion
      collection: 'servicio',     //Nombre del modelo a relacionar 
      via: 'fkUsuario'            //Nombre del atributo fk del otro modelo
    }
=======

    //  ╔═╗╦═╗╦╔╦╗╦╔╦╗╦╦  ╦╔═╗╔═╗
    //  ╠═╝╠╦╝║║║║║ ║ ║╚╗╔╝║╣ ╚═╗
    //  ╩  ╩╚═╩╩ ╩╩ ╩ ╩ ╚╝ ╚═╝╚═╝


    //  ╔═╗╔╦╗╔╗ ╔═╗╔╦╗╔═╗
    //  ║╣ ║║║╠╩╗║╣  ║║╚═╗
    //  ╚═╝╩ ╩╚═╝╚═╝═╩╝╚═╝


    //  ╔═╗╔═╗╔═╗╔═╗╔═╗╦╔═╗╔╦╗╦╔═╗╔╗╔╔═╗
    //  ╠═╣╚═╗╚═╗║ ║║  ║╠═╣ ║ ║║ ║║║║╚═╗
    //  ╩ ╩╚═╝╚═╝╚═╝╚═╝╩╩ ╩ ╩ ╩╚═╝╝╚╝╚═╝

  },

};

