<h5> Описание </h5>
<p> Имеется некая система, которая обрабатывает авиа перелёты. Перелёт — это перевозка
пассажира из одной точки в другую с возможными промежуточными посадками. Т. о. перелёт
можно представить как набор из одного или нескольких элементарных перемещений,
называемых сегментами. Сегмент — это атомарная перевозка, которую для простоты будем
характеризовать всего двумя атрибутами: дата/время вылета и дата/время прилёта.</p>

<h5> Постановка задачи </h5>
    <p>Нужно написать небольшой модуль, который будет заниматься фильтрацией набора
перелётов согласно различным правилам. </p>

1. Вылет до текущего момента времени
2. Имеются сегменты с датой прилёта раньше даты вылета
3. Общее время, проведённое на земле превышает два часа (время на земле — это интервал
    между прилётом одного сегмента и вылетом следующего за ним)
    
<h5> Применяемые технологии </h5>    
<p> 1. Java 13 </p>
<p> 2. Maven </p>
<p> 3. Junit 4.12 </p>

<h5> Структура классов main </h5>
<p>1. Класс Flight - Главный класс перелета </p> 
     <ul>Атрибуты:  
      <li> ListSegments </li>
      <li> id </li>
      </ul>
      </ul>
<p>2. Класс Segment - Класс расписания перелата </p>
     <ul> Атрибуты: 
    <li> id </li>
    <li> departureDate(Время вылета) </li>
    <li> arrivalDate(Время прилета) </li>
  </ul> </ul>
<p>3. Класс FlightBuilder - фабрика создания перелетов c заранее созданной коллекцией перелетов</p>
<p>4. Интерфейс SegmentFilter -  Интерфейс для создания фильтра расписания</p>
<p>5. Класс SegmentFilterImpl - Класс реализующий интерфейс SegmentFilter. C помощью данного класса реализованы поставленные задачи. </p>

<h5> Структура классов Test </h5>
<p>1. Класс FlightBuilderTest - фабрика создания тестовых перелетов c заранее созданной коллекцией перелетов </p>
<p>2. Класс SegmentFilterImplTest - основной класс тестов для тестирования SegmentFilter по тестовой коллекции.</p>
