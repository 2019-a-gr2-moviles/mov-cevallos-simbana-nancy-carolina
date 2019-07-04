/**
 * Servicio.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre: {
      type: 'string',
    },
    //configuracion del HIJO
    fkUsuario:{            //Nombre del fk para la relacion
      model: 'usuario',    //Nombre del modelo a relacionar
      //required: true     //OPCIONAL -> Simepre ingresar el fk

    }


  },

};

