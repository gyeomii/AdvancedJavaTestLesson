<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/cart.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
	<form>
	<table border="1">
	<caption>CART</caption>
		<tr>
			<th id="name">Goods</th>
			<th id="price">Price</th>
			<th id="qty">Quantity</th>
			<th id="sum">Total</th>
		</tr>

		<tr>
			<td></td>
			<td><input type="text" id="tr1"></td>
			<td><input id="qty1"class="i3" type="number" min ="0" value="0"></td>
			<td id="total1"></td>
		</tr>
	
		<tr>
			<td></td>
			<td><input type="text" id="tr2"></td>
			<td><input id="qty2"class="i3" type="number" min ="0" value="0"></td>
			<td id="total2" ></td>
		</tr>
	
		<tr>
			<td></td>
			<td><input type="text" id="tr3"></td>
			<td><input id="qty3"class="i3" type="number" min ="0" value="0"></td>
			<td id="total3"></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="text" id="tr4"></td>
			<td><input id="qty4"class="i3" type="number" min ="0" value="0"></td>
			<td id="total4"></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="text" id="tr5"></td>
			<td><input id="qty5"class="i3" type="number" value="0"></td>
			<td id="total5"></td>
		</tr>
			
		<tr>
			<td></td>
			<td><input type="text" id="tr6"></td>
			<td><input id="qty6"class="i3" type="number" min ="0" value="0"></td>
			<td id="total6"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center" id ="t">Total Price</td>
			<td colspan="2" align="center" id="totalPrice"></td> 
		</tr>
		
	</table>
	<br><br>
	<p>Click 'Get SUM' after input 'Price' and 'Quantity'<p>
	<p>Click 'RESET' when you want to reset</p>
	<input type="button"  id="sumPrice" value="Get SUM" onclick="getTotal()">
	<input type="button" id="reset"  value="Reset" onclick="isReset()">
	</form>
</body>
	
<script>
function getTotal(){
	let p1 = parseInt(document.getElementById('tr1').value);
	let p2 = parseInt(document.getElementById('tr2').value);
	let p3 = parseInt(document.getElementById('tr3').value);
	let p4 = parseInt(document.getElementById('tr4').value);
	let p5 = parseInt(document.getElementById('tr5').value);
	let p6 = parseInt(document.getElementById('tr6').value);
	
	let q1 = parseInt(document.getElementById('qty1').value);
	let q2 = parseInt(document.getElementById('qty2').value);
	let q3 = parseInt(document.getElementById('qty3').value);
	let q4 = parseInt(document.getElementById('qty4').value);
	let q5 = parseInt(document.getElementById('qty5').value);
	let q6 = parseInt(document.getElementById('qty6').value);
	
	
	let t1 = q1*p1;
	let t2 = q2*p2;
	let t3 = q3*p3;
	let t4 = q4*p4;
	let t5 = q5*p5;
	let t6 = q6*p6;
	
	document.getElementById('total1').innerHTML = "￦" + t1;
	document.getElementById('total2').innerHTML = "￦" + t2;
	document.getElementById('total3').innerHTML = "￦" + t3;
	document.getElementById('total4').innerHTML = "￦" + t4;
	document.getElementById('total5').innerHTML = "￦" + t5;
	document.getElementById('total6').innerHTML = "￦" + t6;
	
	let result;
	result = t1 + t2 + t3 + t4 + t5 + t6;
	document.getElementById('totalPrice').innerHTML = "￦" + result;
}
let isReset = function(){
		let cnf = confirm("Reset CART ?");
		if(cnf){
			 document.getElementById("tr1").value = "";
		     document.getElementById("tr2").value = "";
		     document.getElementById("tr3").value = "";
		     document.getElementById("tr4").value = "";
		     document.getElementById("tr5").value = "";
		     document.getElementById("tr6").value = "";
		     
			 document.getElementById("total1").value = "";
		     document.getElementById("total2").value = "";
		     document.getElementById("total3").value = "";
		     document.getElementById("total4").value = "";
		     document.getElementById("total5").value = "";
		     document.getElementById("total6").value = "";
		     
			 document.getElementById("qty1").value = "";
		     document.getElementById("qty2").value = "";
		     document.getElementById("qty3").value = "";
		     document.getElementById("qty4").value = "";
		     document.getElementById("qty5").value = "";
		     document.getElementById("qty6").value = "";
		     
		     document.getElementById("totalPrice").innerHTML = "";
		}
}
</script>
	
</html>