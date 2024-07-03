# plants/urls.py.py

from django.urls import path
from . import views

urlpatterns = [
    path('', views.plants_index, name='plants'),  # List view of plants
    path('<int:id>/', views.plant_detail, name='plant_detail'),  # Detail view of a specific plant
]
