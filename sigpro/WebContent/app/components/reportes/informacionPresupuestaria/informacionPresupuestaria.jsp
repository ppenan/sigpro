<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
	<style>
		.actividad { font-weight: normal !important; }
		.padre {font-weight: bold;}
	    .real { background-color: #f7e681 !important }
	    .realTotal { background-color: #f7e681 !important }
		
		.divPadreNombres{
			float: left; 
		  	width: 200px; 
			min-width: 200px; 
			max-width:200px; 
			overflow:hidden; 
		}	
		
		.divPadreDatos{		
			float: left; 
			display: inline-block;
			white-space: nowrap;	
			overflow:hidden;		
		}
			
		.divTabla{
			float: left;
			max-height: 375px;
			margin-right: -15px;
			overflow-y:hidden;
			overflow-x:hidden;
		}
		
	    .cuerpoTablaNombres {
		    overflow-y: scroll;
		    overflow-x: hidden;
		    display: inline-block;
		    font-size: 13px;
		}
				
		.bordeIzquierda{
		    border-left: 3px double #ccc!important;
		}
		
		.cuerpoTablaDatos {
		    overflow-y: scroll;
		    overflow-x: hidden;
		    display: inline-block;
		    text-align: center;
		    font-size: 13px;
		}
		
		.tablaDatos {
			display: flex;
		    flex-direction: column;
		    align-items: stretch;
		    height: 375px; 
		}
		
		.colorPlanificado{
			color: #303f9e;
		}
		
		.colorReal{
			color: #257129;
		}
		
		.colorPlanificadoFondo{
			background-color: #303f9e;
		}
		
		.colorRealFondo{
			background-color: #257129;
		}
		
		.theadDatos {
			flex-shrink: 0; overflow-x: hidden;
		}
		
		.table-striped>tbody>tr:nth-child(odd)>td, .table-striped>tbody>tr:nth-child(odd)>th {
    		background-color: #f3f3f3;
		}
		
		.label-form {
		    font-size: 13px;
		    opacity: 1;
		    color: rgba(0,0,0,0.38) !important;
		    font-weight: bold;
		}
		
		.leyendaTexto {
		    text-align: right;
		}
		
		.leyendaTexto li {
		    display: inline-block;
		    position: relative;
		    padding: 1px 8px 1px 15px;
		    font-size: smaller;
		}
		
		.leyendaTexto li span {
		    position: absolute;
		    left: 0;
		    width: 12px;
		    height: 12px;
		    border-radius: 4px;
		}
		
	</style>

<div ng-controller="adquisicionesController as controller" class="maincontainer all_page" id="title">
	
    <shiro:lacksPermission name="24010">
			<p ng-init="controller.redireccionSinPermisos()"></p>
	</shiro:lacksPermission>
	    <div class="col-sm-12">
	    	<div style="width: 100%; height: 20%">
	    		<div class="row">
		    		<div class="panel panel-default">
		  				<div class="panel-heading"><h3>Ejecución presupuestaria</h3></div>
					</div>
				</div>
    			<br>
	    		<div class="row">
					<div class="form-group col-sm-3">
						<select  class="inputText" ng-model="controller.prestamo"
							ng-options="a.text for a in controller.prestamos"
							ng-change="controller.validar(1)"></select>
						<label for="prestamo" class="floating-label">Préstamos</label>
					</div>
					
					<div class="form-group col-sm-1">
						<input type="number"  class="inputText" ng-model="controller.fechaInicio" maxlength="4" 
						ng-value="controller.fechaInicio" onblur="this.setAttribute('value', this.value);"
						ng-change="controller.validar(2)"/>
					  	<label for="campo.id" class="floating-label">*Año Inicial</label>
					</div>
					
					<div class="form-group col-sm-1">
						<input type="number"  class="inputText" ng-model="controller.fechaFin" maxlength="4" 
						ng-value="controller.fechaFin" onblur="this.setAttribute('value', this.value);"
						ng-change="controller.validar(3)"/>
					  	<label for="campo.id" class="floating-label">*Año Final</label>
					</div>
					<div class="col-sm-7" align="right" ng-hide="!controller.mostrarDescargar">
						<div class="form-group col-sm-1">
						</div>
						<div class="col-sm-11">
							<div class="btn-group">
								<label class="btn btn-default" ng-model="controller.enMillones" uib-btn-radio="true" ng-click="controller.calcularTamaniosCeldas()" uib-tooltip="Millones de Quetzales" role="button" tabindex="0" aria-invalid="false">
								<span>MQ</span></label>
								<label class="btn btn-default" ng-model="controller.enMillones" uib-btn-radio="false" ng-click="controller.calcularTamaniosCeldas()" uib-tooltip="Quetzales" role="button" tabindex="1" aria-invalid="false">
								<span>Q</span></label>
							</div>
							<div class="btn-group" style="padding-left: 20px;">
								<label class="btn btn-default" ng-model="controller.agrupacionActual" uib-btn-radio="1" ng-click="controller.generar(1)" uib-tooltip="Mensual" role="button" tabindex="1" aria-invalid="false">
								<span>M</span></label>
								<label class="btn btn-default" ng-model="controller.agrupacionActual" uib-btn-radio="2" ng-click="controller.generar(2)" uib-tooltip="Bimestre" role="button" tabindex="2" aria-invalid="false">
								<span>B</span></label>
								<label class="btn btn-default" ng-model="controller.agrupacionActual" uib-btn-radio="3" ng-click="controller.generar(3)" uib-tooltip="Trimestre" role="button" tabindex="3" aria-invalid="false">
								<span>T</span></label>
								<label class="btn btn-default" ng-model="controller.agrupacionActual" uib-btn-radio="4" ng-click="controller.generar(4)" uib-tooltip="Cuatrimestre" role="button" tabindex="4" aria-invalid="false">
								<span>C</span></label>
								<label class="btn btn-default" ng-model="controller.agrupacionActual" uib-btn-radio="5" ng-click="controller.generar(5)" uib-tooltip="Semestre" role="button" tabindex="5" aria-invalid="false">
								<span>S</span></label>
								<label class="btn btn-default" ng-model="controller.agrupacionActual" uib-btn-radio="6" ng-click="controller.generar(6)" uib-tooltip="Anual" role="button" tabindex="6" aria-invalid="false">
								<span>A</span></label>
							</div>
							<div class="btn-group" style="padding-left: 20px;">
								<label class="btn btn-default" ng-model="controller.grupoMostrado.planificado"  uib-btn-checkbox ng-click="controller.verificaSeleccionTipo(1)" uib-tooltip="Planificado" role="button" tabindex="7" aria-invalid="false">
								<span>P</span></label>
								<label class="btn btn-default" ng-model="controller.grupoMostrado.real"  uib-btn-checkbox ng-click="controller.verificaSeleccionTipo(2)" uib-tooltip="Real" role="button" tabindex="8" aria-invalid="false">
								<span>R</span></label>
	    					</div>
							<div class="btn-group" style="padding-left: 20px;">
								<label class="btn btn-default" ng-click="controller.exportarExcel()" uib-tooltip="Exportar" ng-hide="!controller.mostrarDescargar">
								<span class="glyphicon glyphicon glyphicon-export" aria-hidden="true"></span></label>
							</div>
						</div>
					</div>
    			<br><br><br><br>
	    	</div>
	    	<div style="width: 100%; height: 80%" id="reporte">
	    		
				<div class="grid_loading" ng-hide="!controller.mostrarCargando">
						<div class="msg">
							<span><i class="fa fa-spinner fa-spin fa-4x"></i> 
								<br />
								<br /> <b>Cargando, por favor espere...</b> 
							</span>
						</div>
					</div>		
		    	<div class="row" ng-hide="!controller.mostrarDescargar">
		    				
		    		<div class="divPadreNombres">
			    		<div class="divTabla"> 
			    			<table st-table="rowCollection" st-safe-src="datosTabla" class="table table-striped tablaDatos">
								<thead class="theadDatos">
									<tr>
				          				<th st-sort="nombre" style="height: 71px; text-align: center; vertical-align: top; min-width:200px;" class="label-form">Nombre</th>
				         			</tr>
								</thead>
								<tbody class="cuerpoTablaNombres" id="divTablaNombres" ng-mouseover="controller.activarScroll('divTablaNombres')" scrollespejo>
									<tr ng-repeat="row in rowCollection">
							      		<td style="min-width:200px;">{{row.nombre}}</td>
							      	</tr>
								</tbody>
							</table>
		    			</div>
	    			</div>
		    		<div class="divPadreDatos" style="max-width: {{controller.tamanoTotal}}px">
	    				<div class="divTabla">
			    			<table st-table="rowCollection" st-safe-src="datosTabla" class="table table-striped tablaDatos" 
				    				style="max-width: {{controller.tamanoTotal}}px;">
								<thead id="divCabecerasDatos" class="theadDatos">
									<tr>
				         				<th colspan={{controller.colspan}} style="{{controller.estiloCabecera}}" ng-repeat="m in controller.objetoMostrar" class="label-form">{{m.nombreMes}}</th>
				          			</tr>
				          			<tr>
				          				<th ng-repeat="a in controller.aniosfinales" style="{{controller.estiloCelda}} {{controller.estiloAlineacion}}" class="label-form">{{a.ano}}</th>
							        </tr>
								</thead>
								<tbody class="cuerpoTablaDatos" id="divTablaDatos" ng-mouseover="controller.activarScroll('divTablaDatos')" scrollespejo>
							      	<tr ng-repeat="row in rowCollection">
							      		<td ng-repeat="col in columns" style="{{controller.estiloCelda}} {{controller.estiloAlineacion}}">
							      			<span ng-show="controller.grupoMostrado.planificado" class="colorPlanificado">{{row[col] | formatoMillones : controller.enMillones}}</span>
							      			<span ng-show="controller.grupoMostrado.planificado && controller.grupoMostrado.real" > | </span>
							      			<span ng-show="controller.grupoMostrado.real" class="colorReal">{{row.enero[col] | formatoMillones : controller.enMillones}}</span>
							      		</td>
							      	</tr>
								</tbody>
							</table>
						</div>
					</div>
		    		<div class="divTabla">
		    			<table st-table="rowCollection" st-safe-src="datosTabla" class="table table-striped tablaDatos">
							<thead class="theadDatos">
								<tr>
			          				<th nowrap colspan={{controller.colspan}} style="{{controller.estiloCelda}} text-align: center;" class="label-form">Total Anual</th>
			          				<th rowspan="2" style="{{controller.estiloCelda}} text-align: center; vertical-align: top;" class="label-form">Total</th>
			          			</tr>
			          			<tr>
			          				<th ng-repeat="a in controller.aniosTotal" style="{{controller.estiloCelda}} {{controller.estiloAlineacion}};" class="label-form">{{a.ano}}</th>
						        </tr>
							</thead>
							<tbody class="cuerpoTablaNombres bordeIzquierda" id="divTotales" ng-mouseover="controller.activarScroll('divTotales')" scrollespejo>
								<tr ng-repeat="row in rowCollection">
									<td ng-repeat="a in controller.aniosTotal" style="{{controller.estiloCelda}} {{controller.estiloAlineacion}}">
										<span ng-show="controller.grupoMostrado.planificado" class="colorPlanificado">{{row[1] | formatoMillones : controller.enMillones}}</span>
						      			<span ng-show="controller.grupoMostrado.planificado && controller.grupoMostrado.real" > | </span>
						      			<span ng-show="controller.grupoMostrado.real" class="colorReal">{{row[1] | formatoMillones : controller.enMillones}}</span>
									</td>
						      		<td style="{{controller.estiloCelda}} {{controller.estiloAlineacion}}">
						      			<span ng-show="controller.grupoMostrado.planificado" class="colorPlanificado">{{row[4] | formatoMillones : controller.enMillones}}</span>
						      			<span ng-show="controller.grupoMostrado.planificado && controller.grupoMostrado.real" > | </span>
						      			<span ng-show="controller.grupoMostrado.real" class="colorReal">{{row[4] | formatoMillones : controller.enMillones}}</span>
						      		</td>
						      	</tr>
							</tbody>
						</table>
		    		</div>
				</div>
	    	</div>
	    	<div style="text-align: center;">
	    		<br>
	    		<ol class="leyendaTexto"  ng-hide="!controller.mostrarDescargar">
					<li ng-show="controller.grupoMostrado.planificado"><span class="colorPlanificadoFondo"></span>Planificado</li>
			        <li ng-show="controller.grupoMostrado.real"><span class="colorRealFondo"></span>Real</li>
				</ol>
				<br>
				<label class="btn btn-default" ng-click="controller.anterior()" uib-tooltip="Anterior" ng-hide="!controller.movimiento" 
						tooltip-placement="bottom" ng-disabled="!controller.AnteriorActivo">
				<span class="glyphicon glyphicon-chevron-left"></span></label>
				<label class="btn btn-default" ng-click="controller.siguiente()" uib-tooltip="Siguiente" ng-hide="!controller.movimiento"
						tooltip-placement="bottom" ng-disabled="!controller.SiguienteActivo">
				<span class="glyphicon glyphicon-chevron-right"></span></label>
	    	</div>
    	</div>
    </div>
</div>