/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { HcPortalTestModule } from '../../../test.module';
import { VsSpo2DetailComponent } from '../../../../../../main/webapp/app/entities/vs-spo-2/vs-spo-2-detail.component';
import { VsSpo2Service } from '../../../../../../main/webapp/app/entities/vs-spo-2/vs-spo-2.service';
import { VsSpo2 } from '../../../../../../main/webapp/app/entities/vs-spo-2/vs-spo-2.model';

describe('Component Tests', () => {

    describe('VsSpo2 Management Detail Component', () => {
        let comp: VsSpo2DetailComponent;
        let fixture: ComponentFixture<VsSpo2DetailComponent>;
        let service: VsSpo2Service;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsSpo2DetailComponent],
                providers: [
                    VsSpo2Service
                ]
            })
            .overrideTemplate(VsSpo2DetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsSpo2DetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsSpo2Service);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new VsSpo2('123')
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith('123');
                expect(comp.vsSpo2).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
