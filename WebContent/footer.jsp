			</table></div>
			<div class="form"><form method="post" autocomplete="off" action="?action=<?=$action?>">
				<table>
					<tr><td>Имя</td><td><input type="text" name="firstName" value=""></td></tr>
					<tr><td>Фамилия</td><td><input type="text" name="lastName" value=""></td></tr>
					<tr><td>Телефон</td><td><input type="text" name="phoneNumber" value=""></td></tr>
					<tr><td>Зарплата</td><td><input type="text" name="salary" value=""></td></tr>
					<tr><td>Адрес</td><td><input type="text" name="address" value=""></td></tr>
					<tr><td>Стаж</td><td><input type="text" name="expirience" value=""></td></tr>
				</table>
				<div class="buttons"><? $getButtons(); ?></div>
			</form></div>
		</div>
	</body>
</html>