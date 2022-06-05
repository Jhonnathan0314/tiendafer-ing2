package com.tiendafer.view;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tiendafer.model.Bill;
import com.tiendafer.model.Client;
import com.tiendafer.model.Order;
import com.tiendafer.model.OrderDetail;
import com.tiendafer.model.Product;
import com.tiendafer.model.ProductSold;
import com.tiendafer.model.Provider;
import com.tiendafer.model.Section;
import com.tiendafer.modeldao.BillDAO;
import com.tiendafer.modeldao.ClientDAO;
import com.tiendafer.modeldao.OrderDAO;
import com.tiendafer.modeldao.OrderDetailDAO;
import com.tiendafer.modeldao.ProductDAO;
import com.tiendafer.modeldao.ProductSoldDAO;
import com.tiendafer.modeldao.ProviderDAO;
import com.tiendafer.modeldao.SectionDAO;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String login = "index.jsp";

	private String home = "html/inicio.jsp";

	private String section = "html/Section/section.jsp";
	private String addSection = "html/Section/addSection.jsp";
	private String updateSection = "html/Section/updateSection.jsp";
	private String searchSection = "html/Section/searchSection.jsp";
	private String tableSection = "html/Section/tableSection.jsp";

	private String product = "html/Product/product.jsp";
	private String addProduct = "html/Product/addProduct.jsp";
	private String updateProduct = "html/Product/updateProduct.jsp";
	private String searchProduct = "html/Product/searchProduct.jsp";
	private String tableProduct = "html/Product/tableProduct.jsp";

	private String client = "html/Client/client.jsp";
	private String addClient = "html/Client/addClient.jsp";
	private String updateClient = "html/Client/updateClient.jsp";
	private String searchClient = "html/Client/searchClient.jsp";
	private String tableClient = "html/Client/tableClient.jsp";

	private String provider = "html/Provider/provider.jsp";
	private String addProvider = "html/Provider/addProvider.jsp";
	private String updateProvider = "html/Provider/updateProvider.jsp";
	private String searchProvider = "html/Provider/searchProvider.jsp";
	private String tableProvider = "html/Provider/tableProvider.jsp";

	private String bill = "html/Bill/bill.jsp";
	private String addBill = "html/Bill/addBill.jsp";
	private String tableProductSold = "html/Bill/tableProductSold.jsp";
	private String tableBill = "html/Bill/tableBill.jsp";
	private String searchBill = "html/Bill/searchBill.jsp";

	private String payment = "html/Payment/payment.jsp";
	private String addPayment = "html/Payment/addPayment.jsp";
	private String searchPayment = "html/Payment/searchPayment.jsp";

	private String order = "html/Order/order.jsp";
	private String addOrder = "html/Order/addOrder.jsp";
	private String tableOrderDetail = "html/Order/tableOrderDetail.jsp";
	private String tableOrder = "html/Order/tableOrder.jsp";
	private String searchOrder = "html/Order/searchOrder.jsp";

	private String reports = "html/Reports/report.jsp";

	private int totalPagar;
//	private int item;
	private int monto;
	
	private SectionDAO sectionDAO;
	private ProductDAO productDAO;
	private ProviderDAO providerDAO;
	private ClientDAO clientDAO;
	private BillDAO billDAO;
	private ProductSoldDAO productSoldDAO;
	private OrderDAO orderDAO;
	private OrderDetailDAO orderDetailDAO;

	private Product productObject;
	private Section sectionObject;
	private Provider providerObject;
	private Client clientObject;
	private Bill billObject;
	private ProductSold productSold;
	private Order orderObject;
	private OrderDetail orderDetail;

	public Servlet() {
		sectionDAO = new SectionDAO();
		productDAO = new ProductDAO();
		providerDAO = new ProviderDAO();
		clientDAO = new ClientDAO();
		billDAO = new BillDAO();
		productSoldDAO = new ProductSoldDAO();
		orderDAO = new OrderDAO();
		orderDetailDAO = new OrderDetailDAO();

		sectionObject = new Section();
		productObject = new Product(0, "", 0, "", 0);
		productObject.addSection(new Section(1, ""));
		providerObject = new Provider(new BigInteger(0+""), "", "");
		clientObject = new Client(0, "");
		billObject = new Bill();
		productSold = new ProductSold();
		orderObject = new Order();
		orderDetail = new OrderDetail();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu = request.getParameter("menu");
		String action = request.getParameter("action");

		if(menu.equalsIgnoreCase("Ingresar") || menu.equalsIgnoreCase("Home")) {
			request.getRequestDispatcher(home).forward(request, response);
		}

		if(menu.equalsIgnoreCase("Section")) {

			accionesSeccion(action, request, response);
 
		}

		if(menu.equalsIgnoreCase("Product")) {

			accionesProducto(action, request, response);

		}

		if(menu.equalsIgnoreCase("Provider")) {

			accionesProveedor(action, request, response);

		}

		if(menu.equalsIgnoreCase("Order")) {
			
			accionesPedido(action, request, response);

		}

		if(menu.equalsIgnoreCase("Client")) {

			accionesCliente(action, request, response);

		}

		if(menu.equalsIgnoreCase("Bill")) {

			accionesFactura(action, request, response);

		}

		if(menu.equalsIgnoreCase("Payment")) {

			accionesPago(action, request, response);

		}

		if(menu.equalsIgnoreCase("Report")) {
			request.getRequestDispatcher(reports).forward(request, response);
		}
	}

	private void accionesPago(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (action) {
		case "":
			List<Product> products = new ArrayList<Product>();
			products = productDAO.searchAll();
			request.setAttribute("products", products);
			
			List<Client> clients = new ArrayList<Client>();
			clients = clientDAO.searchAll();
			request.setAttribute("clients", clients);
			
			request.getRequestDispatcher(addPayment).forward(request, response);
			break;

		case "BuscarCliente":
			int dni = Integer.parseInt(request.getParameter("dniCliente"));
			clientObject.setDni(dni);
			clientObject = clientDAO.searchByDni(dni);
			
			request.setAttribute("clienteB", clientObject);
			break;
			
		case "BuscarFacturas":
			List<Bill> bills = new ArrayList<Bill>();
			bills = billDAO.searchByClient(clientObject.getDni());
			
			request.setAttribute("bills", bills);
			
			int deudaTotal = 0;
			for(int i=0; i<bills.size(); i++) {
				deudaTotal += bills.get(i).getSaleValue();
			}
			
			request.setAttribute("deudaTotal", deudaTotal);
			break;
			
		case "Pagar":
			int txtEfectivo = Integer.parseInt(request.getParameter("txtEfectivo"));
			int saldoActual = 0;
			int nuevoSaldo = 0;
			System.out.println("EFECTIVO INICIAL: " + txtEfectivo);
			
			bills = new ArrayList<Bill>();
			bills = billDAO.searchByClient(clientObject.getDni());
			
			for(int i=0; i<bills.size(); i++) {
				saldoActual = bills.get(i).getSaleValue();
				System.out.println("SALDO ACTUAL i= " + i + ": " + saldoActual);

				nuevoSaldo = saldoActual - txtEfectivo;
				System.out.println("NUEVO SALDO i= " + i + ": " + nuevoSaldo);
				
				if(nuevoSaldo == 0) {
					System.out.println("EFECTIVO i= " + i + ": " + txtEfectivo);
					nuevoSaldo = 0;
				}
				
				System.out.println("NUEVO SALDO it2 i= " + i + ": " + nuevoSaldo);
				bills.get(i).setSaleValue(nuevoSaldo);
			}
			
			request.setAttribute("cambio", txtEfectivo);
			break;
			
		case "Cancelar":
			billObject = new Bill();
			bills = new ArrayList<Bill>();
			
			request.getRequestDispatcher("Servlet?menu=Payment&action=").forward(request, response);
			break;
			
		default:
			break;
		}
		
		request.getRequestDispatcher(addPayment).forward(request, response);
	}

	private void accionesPedido(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		products = productDAO.searchAll();
		request.setAttribute("products", products);
		
		List<Provider> providers = new ArrayList<Provider>();
		providers = providerDAO.searchAll();
		request.setAttribute("providers", providers);
		
		switch (action) {
		case "searchAll":
			List<Order> orders = new ArrayList<Order>();
			orders = orderDAO.searchAll();

			request.setAttribute("orders", orders);
			
			request.getRequestDispatcher(order).forward(request, response);
			break;
			
		case "detailTable":
			int orderNumber = Integer.parseInt(request.getParameter("codPed"));
			
			List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			orderDetails = orderDetailDAO.searchByOrder(orderNumber);

			request.setAttribute("orderDetails", orderDetails);
			
			request.getRequestDispatcher(tableOrderDetail).forward(request, response);
			break;
			
		case "addOrder":
			request.getRequestDispatcher(addOrder).forward(request, response);
			break;
		
		case "BuscarProveedor":
			String nit = request.getParameter("nitProvider");
			providerObject.setNit(new BigInteger(nit));
			providerObject = providerDAO.searchByNit(new BigInteger(nit));
			
			request.setAttribute("proveedorB", providerObject);
			
			totalPagar = 0;
			for(int i=0; i<orderObject.getOrderDetail().size(); i++) {
				totalPagar += orderObject.getOrderDetail().get(i).getTotalValue();
			}
			
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("compras", orderObject.getOrderDetail());
			break;

		case "BuscarProducto":
			int codeProducto = Integer.parseInt(request.getParameter("productCode"));
			productObject = productDAO.searchByCode(codeProducto);
			
			request.setAttribute("productoB", productObject);
			
			totalPagar = 0;
			for(int i=0; i<orderObject.getOrderDetail().size(); i++) {
				totalPagar += orderObject.getOrderDetail().get(i).getTotalValue();
			}
			
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("compras", orderObject.getOrderDetail());
			
			request.setAttribute("proveedorB", providerObject);
			break;
			
		case "Agregar":
			totalPagar = 0;
			codeProducto = productObject.getCode();
			int cantidadPedida = Integer.parseInt(request.getParameter("txtCantidadPedida"));
			int cantidadRecibida = Integer.parseInt(request.getParameter("txtCantidadRecibida"));
			int valorUnitario = Integer.parseInt(request.getParameter("txtValorUnitario"));
			monto = valorUnitario * cantidadRecibida;
			
			orderDetail = new OrderDetail();
			orderDetail.setProduct(productDAO.searchByCode(codeProducto));
			orderDetail.setOrderedAmount(cantidadPedida);
			orderDetail.setReceivedAmount(cantidadRecibida);
			orderDetail.setUnitValue(valorUnitario);
			orderDetail.setTotalValue(monto);
			
			orderObject.getOrderDetail().add(orderDetail);
			
			for(int i=0; i<orderObject.getOrderDetail().size(); i++) {
				totalPagar += orderObject.getOrderDetail().get(i).getTotalValue();
			}
			
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("compras", orderObject.getOrderDetail());
			
			request.setAttribute("proveedorB", providerObject);
			break;
			
		case "Generar":
			cantidadPedida = 0;
			cantidadRecibida = 0;
			int nuevaCantidad = 0;
			for(int i=0; i<orderObject.getOrderDetail().size(); i++) {
				codeProducto = orderObject.getOrderDetail().get(i).getProduct().getCode();
				productObject = productDAO.searchByCode(codeProducto);
				cantidadPedida = orderObject.getOrderDetail().get(i).getOrderedAmount();
				cantidadRecibida = orderObject.getOrderDetail().get(i).getReceivedAmount();
				nuevaCantidad = productObject.getQuantityAvailable() + cantidadRecibida;
				
				productDAO.updateQuantity(codeProducto, nuevaCantidad);
			}
			
			String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
			orderObject.setDate(timeStamp);
			orderObject.setTotalValue(totalPagar);
			orderObject.setProvider(providerDAO.searchByNit(providerObject.getNit()));
			orderDAO.createOrder(orderObject);
			
			int orderId = orderDAO.searchLastOrder();
			for(int i=0; i<orderObject.getOrderDetail().size(); i++) {
				orderDetail = new OrderDetail();
				orderDetail.setOrder(orderDAO.searchByCode(orderId));
				orderDetail.setProduct(orderObject.getOrderDetail().get(i).getProduct());
				orderDetail.setOrderedAmount(orderObject.getOrderDetail().get(i).getOrderedAmount());
				orderDetail.setReceivedAmount(orderObject.getOrderDetail().get(i).getReceivedAmount());
				orderDetail.setUnitValue(orderObject.getOrderDetail().get(i).getUnitValue());
				orderDetail.setTotalValue(orderObject.getOrderDetail().get(i).getTotalValue());
				orderDetailDAO.createOrderDetail(orderDetail);
			}
			
			orderObject = new Order();
			orders = new ArrayList<Order>();
			
			orderDetail = new OrderDetail();
			orderDetails = new ArrayList<OrderDetail>();
			break;
			
		case "Consultar":
			request.getRequestDispatcher(searchOrder).forward(request, response);
			break;
			
		case "Buscar":
			nit = request.getParameter("txtProviderNit");
			String date = request.getParameter("txtOrderDate");
			orders = new ArrayList<Order>();
			if(!nit.equals("0")) {
				orders = new ArrayList<Order>();
				orders = orderDAO.searchByProvider(nit);
			}
			if(!date.isEmpty()) {
				orders = new ArrayList<Order>();
				orders = orderDAO.searchByDate(date);
			}
			
			request.setAttribute("orders2", orders);
			
			request.getRequestDispatcher(tableOrder).forward(request, response);
			break;
			
		case "Delete":
			codeProducto = Integer.parseInt(request.getParameter("idP"));
			for(int i=0; i<orderObject.getOrderDetail().size(); i++) {
				if(orderObject.getOrderDetail().get(i).getProduct().getCode() == codeProducto) {
					orderObject.getOrderDetail().remove(i);
				}
			}

			totalPagar = 0;
			for(int i=0; i<orderObject.getOrderDetail().size(); i++) {
				totalPagar += orderObject.getOrderDetail().get(i).getTotalValue();
			}
			
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("compras", orderObject.getOrderDetail());
			
			request.setAttribute("proveedorB", providerObject);
			break;
			
		case "Cancelar":
			orderObject = new Order();
			orders = new ArrayList<Order>();
			
			orderDetail = new OrderDetail();
			orderDetails = new ArrayList<OrderDetail>();
			
			request.getRequestDispatcher("Servlet?menu=Order&action=searchAll").forward(request, response);
			break;
			
		default:
			break;
		}
		
		request.getRequestDispatcher(addOrder).forward(request, response);
	}

	private void accionesFactura(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		products = productDAO.searchAll();
		request.setAttribute("products", products);
		
		List<Client> clients = new ArrayList<Client>();
		clients = clientDAO.searchAll();
		request.setAttribute("clients", clients);
		
		switch (action) {
		case "searchAll":
			List<Bill> bills = new ArrayList<Bill>();
			bills = billDAO.searchAll();

			request.setAttribute("bills", bills);
			
			request.getRequestDispatcher(bill).forward(request, response);
			break;
			
		case "detailTable":
			int billNumber = Integer.parseInt(request.getParameter("codFact"));
			
			List<ProductSold> productSolds = new ArrayList<ProductSold>();
			productSolds = productSoldDAO.searchByBill(billNumber);

			request.setAttribute("productSolds", productSolds);
			
			request.getRequestDispatcher(tableProductSold).forward(request, response);
			break;
			
		case "addBill":
			request.getRequestDispatcher(addBill).forward(request, response);
			break;
		
		case "BuscarCliente":
			int dni = Integer.parseInt(request.getParameter("dniCliente"));
			clientObject.setDni(dni);
			clientObject = clientDAO.searchByDni(dni);
			
			request.setAttribute("clienteB", clientObject);
			
			totalPagar = 0;
			for(int i=0; i<billObject.getProductSold().size(); i++) {
				totalPagar += billObject.getProductSold().get(i).getTotalValue();
			}
			
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("ventas", billObject.getProductSold());
			break;

		case "BuscarProducto":
			int codeProducto = Integer.parseInt(request.getParameter("productCode"));
			productObject = productDAO.searchByCode(codeProducto);
			
			request.setAttribute("productoB", productObject);
			
			totalPagar = 0;
			for(int i=0; i<billObject.getProductSold().size(); i++) {
				totalPagar += billObject.getProductSold().get(i).getTotalValue();
			}
			
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("ventas", billObject.getProductSold());
			
			request.setAttribute("clienteB", clientObject);
			break;
			
		case "Agregar":
			totalPagar = 0;
			codeProducto = productObject.getCode();
			int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
			int valorUnitario = Integer.parseInt(request.getParameter("txtValorUnitario"));
			monto = valorUnitario * cantidad;
			
			productSold = new ProductSold();
			productSold.setProduct(productDAO.searchByCode(codeProducto));
			productSold.setProductAmount(cantidad);
			productSold.setUnitValue(valorUnitario);
			productSold.setTotalValue(monto);
			
			billObject.getProductSold().add(productSold);
			
			for(int i=0; i<billObject.getProductSold().size(); i++) {
				totalPagar += billObject.getProductSold().get(i).getTotalValue();
			}
			
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("ventas", billObject.getProductSold());
			request.setAttribute("monto", monto);
			
			request.setAttribute("clienteB", clientObject);
			break;
			
		case "Generar":
			cantidad = 0;
			int nuevaCantidad = 0;
			for(int i=0; i<billObject.getProductSold().size(); i++) {
				codeProducto = billObject.getProductSold().get(i).getProduct().getCode();
				productObject = productDAO.searchByCode(codeProducto);
				cantidad = billObject.getProductSold().get(i).getProductAmount();
				nuevaCantidad = productObject.getQuantityAvailable() - cantidad;
				
				productDAO.updateQuantity(codeProducto, nuevaCantidad);
			}
			
			String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
			billObject.setDate(timeStamp);
			billObject.setSaleValue(totalPagar);
			billObject.setClient(clientDAO.searchByDni(clientObject.getDni()));
			billDAO.createBill(billObject);
			
			int billId = billDAO.searchLastBill();
			for(int i=0; i<billObject.getProductSold().size(); i++) {
				productSold = new ProductSold();
				productSold.setBill(billDAO.searchByCode(billId));
				productSold.setProduct(billObject.getProductSold().get(i).getProduct());
				productSold.setProductAmount(billObject.getProductSold().get(i).getProductAmount());
				productSold.setUnitValue(billObject.getProductSold().get(i).getUnitValue());
				productSold.setTotalValue(billObject.getProductSold().get(i).getTotalValue());
				productSoldDAO.createProductSold(productSold);
			}
			
			billObject = new Bill();
			bills = new ArrayList<Bill>();
			
			productSold = new ProductSold();
			productSolds = new ArrayList<ProductSold>();
			break;
			
		case "Delete":
			codeProducto = Integer.parseInt(request.getParameter("idP"));
			for(int i=0; i<billObject.getProductSold().size(); i++) {
				if(billObject.getProductSold().get(i).getProduct().getCode() == codeProducto) {
					billObject.getProductSold().remove(i);
				}
			}

			totalPagar = 0;
			for(int i=0; i<billObject.getProductSold().size(); i++) {
				totalPagar += billObject.getProductSold().get(i).getTotalValue();
			}
			
			request.setAttribute("totalPagar", totalPagar);
			request.setAttribute("ventas", billObject.getProductSold());
			
			request.setAttribute("clienteB", clientObject);
			break;
			
		case "Consultar":
			request.getRequestDispatcher(searchBill).forward(request, response);
			break;
			
		case "Buscar":
			dni = Integer.parseInt(request.getParameter("txtDniClient"));
			String date = request.getParameter("txtSearchDateBill");
			bills = new ArrayList<Bill>();
			if(dni != 0) {
				bills = new ArrayList<Bill>();
				bills = billDAO.searchByClient(dni);
			}
			if(!date.isEmpty()) {
				bills = new ArrayList<Bill>();
				bills = billDAO.searchByDate(date);
			}
			
			request.setAttribute("bills2", bills);
			
			request.getRequestDispatcher(tableBill).forward(request, response);
			break;
			
		case "Cancelar":
			billObject = new Bill();
			bills = new ArrayList<Bill>();
			
			productSold = new ProductSold();
			productSolds = new ArrayList<ProductSold>();
			
			request.getRequestDispatcher("Servlet?menu=Bill&action=searchAll").forward(request, response);
			break;
			
		default:
			break;
		}
		
		request.getRequestDispatcher(addBill).forward(request, response);
	}

	private void accionesSeccion(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Section> sections = new ArrayList<Section>();
		sections = sectionDAO.searchAll();
		request.setAttribute("sections", sections);

		List<Product> products = new ArrayList<Product>();

		switch (action) {
		case "searchAll":
			request.getRequestDispatcher(searchSection).forward(request, response);
			break;

		case "searchByCode":
			request.getRequestDispatcher(tableSection).forward(request, response);
			break;

		case "searchByName":
			request.getRequestDispatcher(tableSection).forward(request, response);
			break;

		case "Crear":
			request.getRequestDispatcher(addSection).forward(request, response);
			break;

		case "Registrar":
			String name = request.getParameter("txtNombreCrearSeccion");

			sectionObject = new Section();
			sectionObject.setName(name);

			sectionDAO.createSection(sectionObject);

			request.getRequestDispatcher(tableSection).forward(request, response);
			break;

		case "Cancelar":
			request.getRequestDispatcher("Servlet?menu=Section&action= ").forward(request, response);
			break;

		case "Consultar":
			sections = new ArrayList<Section>();
			sections = sectionDAO.searchAll();
			request.setAttribute("sections", sections);

			request.getRequestDispatcher(tableSection).forward(request, response);
			break;

		case "Modificar":
			request.getRequestDispatcher(updateSection).forward(request, response);
			break;

		case "Guardar":
			int code = Integer.parseInt(request.getParameter("selectSection"));
			String nuevoNombre = request.getParameter("txtNewSectionName");

			sectionDAO.updateSection(code, nuevoNombre);

			sections = new ArrayList<Section>();
			sections = sectionDAO.searchAll();
			request.setAttribute("sections", sections);

			request.getRequestDispatcher(tableSection).forward(request, response);
			break;

		case "searchSection":
			String secCode = request.getParameter("secCode");
			
			products = new ArrayList<Product>();
			products = productDAO.searchProductsBySection(secCode);
			request.setAttribute("products", products);
			
			request.getRequestDispatcher("Servlet?menu=Section&action=searchAll").forward(request, response);
			break;
			
		default:
			request.getRequestDispatcher(section).forward(request, response);
			break;
		}
	}

	private void accionesProducto(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		products = productDAO.searchAll();
		request.setAttribute("products", products);

		List<Section> sections = new ArrayList<Section>();
		sections = sectionDAO.searchAll();
		request.setAttribute("sections", sections);

		switch (action) {
		case "searchAll":
			products = new ArrayList<Product>();
			products = productDAO.searchAll();
			request.setAttribute("products", products);

			request.getRequestDispatcher(product).forward(request, response);
			break;

		case "searchByCode":
			request.getRequestDispatcher(tableProduct).forward(request, response);
			break;

		case "searchByName":
			request.getRequestDispatcher(tableProduct).forward(request, response);
			break;

		case "searchByValue":
			request.getRequestDispatcher(tableProduct).forward(request, response);
			break;

		case "Crear":
			request.getRequestDispatcher(addProduct).forward(request, response);
			break;

		case "Registrar":
			int sectionCode = Integer.parseInt(request.getParameter("selectSection"));
			String name = request.getParameter("txtNewProductName");
			int quantity = Integer.parseInt(request.getParameter("txtNewProductQuantity"));
			int value = Integer.parseInt(request.getParameter("txtNewProductValue"));
			String change = request.getParameter("txtNewProductChange");

			productObject = new Product();
			if(sectionCode != 0) {
				productObject.setSection(sectionDAO.searchByCode(sectionCode));
			}else {
				productObject.setSection(new Section(0, ""));
			}
			productObject.setName(name);
			productObject.setQuantityAvailable(quantity);
			productObject.setValue(value);
			productObject.setChange(change);

			productDAO.createProduct(productObject);

			request.getRequestDispatcher("Servlet?menu=Product&action=searchAll").forward(request, response);
			break;

		case "Cancelar":
			request.getRequestDispatcher("Servlet?menu=Product&action=searchAll").forward(request, response);
			break;

		case "Consultar":
			request.getRequestDispatcher(searchProduct).forward(request, response);
			break;

		case "Buscar":
			int searchCode = Integer.parseInt(request.getParameter("txtProductCode"));
			String txtName = request.getParameter("txtProductName");
			int txtValue = Integer.parseInt(request.getParameter("txtProductValue"));

			products = new ArrayList<Product>();

			if(searchCode != 0) {
				productObject = productDAO.searchByCode(searchCode);
				products.add(productObject);
				request.setAttribute("product2", products);
				request.getRequestDispatcher("Servlet?menu=Product&action=searchByCode").forward(request, response);
			}
			if(!txtName.isEmpty()) {
				products = productDAO.searchByName(txtName);
				request.setAttribute("product2", products);
				request.getRequestDispatcher("Servlet?menu=Product&action=searchByName").forward(request, response);
			}
			if(txtValue != 0) {
				products = productDAO.searchByValue(txtValue);
				request.setAttribute("product2", products);
				request.getRequestDispatcher("Servlet?menu=Product&action=searchByValue").forward(request, response);
			}

			break;

		case "Modificar":
			request.getRequestDispatcher(updateProduct).forward(request, response);
			break;

		case "Guardar":
			String txtCode = request.getParameter("productCode");
			String txtProductName = request.getParameter("txtNewProductName");
			String txtQuantity = request.getParameter("txtNewProductQuantity");
			String txtProductValue = request.getParameter("txtNewProductValue");
			String txtChange = request.getParameter("txtNewProductChange");

			if(!txtCode.isEmpty()) {
				if(!txtProductName.isEmpty()) {
					productDAO.updateName(Integer.parseInt(txtCode), txtProductName);
				}
				if(!txtQuantity.isEmpty()) {
					productDAO.updateQuantity(Integer.parseInt(txtCode), Integer.parseInt(txtQuantity));
				}
				if(!txtProductValue.isEmpty()) {
					productDAO.updateValue(Integer.parseInt(txtCode), Integer.parseInt(txtProductValue));
				}
				if(!txtChange.isEmpty()) {
					productDAO.updateChange(Integer.parseInt(txtCode), txtChange);
				}
			}

			request.getRequestDispatcher("Servlet?menu=Product&action=searchAll").forward(request, response);
			break;

		default:
			request.getRequestDispatcher(product).forward(request, response);
			throw new AssertionError();
		}
	}

	private void accionesProveedor(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		List<Provider> providers = new ArrayList<Provider>();
		providers = providerDAO.searchAll();
		request.setAttribute("providers", providers);

		switch (action) {
		case "searchAll":
			providers = new ArrayList<Provider>();
			providers = providerDAO.searchAll();
			request.setAttribute("providers", providers);

			request.getRequestDispatcher(provider).forward(request, response);
			break;

		case "searchByNit":
			request.getRequestDispatcher(tableProvider).forward(request, response);
			break;

		case "searchBySupplierName":
			request.getRequestDispatcher(tableProvider).forward(request, response);
			break;

		case "searchBySellerName":
			request.getRequestDispatcher(tableProvider).forward(request, response);
			break;

		case "Crear":
			request.getRequestDispatcher(addProvider).forward(request, response);
			break;

		case "Registrar":
			String nit = request.getParameter("txtNewNit");
			String supplierName = request.getParameter("txtNewSupplierName");
			String sellerName = request.getParameter("txtNewSellerName");

			providerObject = new Provider();
			providerObject.setNit(new BigInteger(nit));
			providerObject.setSupplierName(supplierName);
			providerObject.setSellerName(sellerName);

			providerDAO.createProvider(providerObject);

			request.getRequestDispatcher("Servlet?menu=Provider&action=searchAll").forward(request, response);
			break;

		case "Cancelar":
			request.getRequestDispatcher("Servlet?menu=Provider&action=searchAll").forward(request, response);
			break;

		case "Consultar":
			request.getRequestDispatcher(searchProvider).forward(request, response);
			break;

		case "Buscar":
			String searchNit = request.getParameter("txtSearchNit");
			String txtSupplierName = request.getParameter("txtSearchSupplierName");
			String txtSellerName = request.getParameter("txtSearchSellerName");

			providers = new ArrayList<Provider>();

			if(!searchNit.isEmpty()) {
				providerObject = providerDAO.searchByNit(new BigInteger(searchNit));
				providers.add(providerObject);
				request.setAttribute("provider2", providers);
				request.getRequestDispatcher("Servlet?menu=Provider&action=searchByNit").forward(request, response);
			}
			if(!txtSupplierName.isEmpty()) {
				providers = providerDAO.searchBySupplierName(txtSupplierName);
				request.setAttribute("provider2", providers);
				request.getRequestDispatcher("Servlet?menu=Provider&action=searchBySupplierName").forward(request, response);
			}
			if(!txtSellerName.isEmpty()) {
				providers = providerDAO.searchBySellerName(txtSellerName);
				request.setAttribute("provider2", providers);
				request.getRequestDispatcher("Servlet?menu=Provider&action=searchBySellerName").forward(request, response);
			}

			break;

		case "Modificar":
			request.getRequestDispatcher(updateProvider).forward(request, response);
			break;

		case "Guardar":
			String txtNit = request.getParameter("nitProveedor");
			String txtNewSupplierName = request.getParameter("txtNewSupplierName");
			String txtNewSellerName = request.getParameter("txtNewSellerName");

			if(!txtNewSupplierName.isEmpty()) {
				providerDAO.updateSupplierName(new BigInteger(txtNit), txtNewSupplierName);
			}
			if(!txtNewSellerName.isEmpty()) {
				providerDAO.updateSellerName(new BigInteger(txtNit), txtNewSellerName);
			}

			request.getRequestDispatcher("Servlet?menu=Provider&action=searchAll").forward(request, response);
			break;

		default:
			request.getRequestDispatcher(provider).forward(request, response);
			throw new AssertionError();
		}
	}

	private void accionesCliente(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients = new ArrayList<Client>();
		clients = clientDAO.searchAll();
		request.setAttribute("clients", clients);

		switch (action) {
		case "searchAll":
			clients = new ArrayList<Client>();
			clients = clientDAO.searchAll();
			request.setAttribute("clients", clients);

			request.getRequestDispatcher(client).forward(request, response);
			break;

		case "searchByDni":
			request.getRequestDispatcher(tableClient).forward(request, response);
			break;

		case "searchByName":
			request.getRequestDispatcher(tableClient).forward(request, response);
			break;

		case "Crear":
			request.getRequestDispatcher(addClient).forward(request, response);
			break;

		case "Registrar":
			int dni = Integer.parseInt(request.getParameter("txtNewDni"));
			String name = request.getParameter("txtNewClientName");

			clientObject = new Client();
			clientObject.setDni(dni);
			clientObject.setName(name);

			clientDAO.createClient(clientObject);

			request.getRequestDispatcher("Servlet?menu=Client&action=searchAll").forward(request, response);
			break;

		case "Cancelar":
			request.getRequestDispatcher("Servlet?menu=Client&action=searchAll").forward(request, response);
			break;

		case "Consultar":
			request.getRequestDispatcher(searchClient).forward(request, response);
			break;

		case "Buscar":
			int searchDni = 0;
			try {
				searchDni = Integer.parseInt(request.getParameter("txtSearchDni"));
			} catch (Exception e) {
				searchDni = 0;
			}
			String searchName = request.getParameter("txtSearchName");

			clients = new ArrayList<Client>();

			if(searchDni != 0) {
				clientObject = clientDAO.searchByDni(searchDni);
				clients.add(clientObject);
				request.setAttribute("client2", clients);
				request.getRequestDispatcher("Servlet?menu=Client&action=searchByDni").forward(request, response);
			}
			if(!searchName.isEmpty()) {
				clients = clientDAO.searchByName(searchName);
				request.setAttribute("client2", clients);
				request.getRequestDispatcher("Servlet?menu=Client&action=searchByName").forward(request, response);
			}

			break;

		case "Modificar":
			request.getRequestDispatcher(updateClient).forward(request, response);
			break;

		case "Guardar":
			dni = Integer.parseInt(request.getParameter("dniCliente"));
			String nuevoNombre = request.getParameter("txtNewClientName");

			clientDAO.updateName(dni, nuevoNombre);

			request.getRequestDispatcher("Servlet?menu=Client&action=searchAll").forward(request, response);
			break;

		default:
			request.getRequestDispatcher(client).forward(request, response);
			throw new AssertionError();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
